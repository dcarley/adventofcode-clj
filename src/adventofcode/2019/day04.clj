(ns adventofcode.2019.day04
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

(def fixture
  (map #(Integer/parseInt %)
       (-> "2019/day04"
           io/resource
           slurp
           str/trim
           (str/split #"-"))))

;; https://stackoverflow.com/a/29942388
(defn digits
  [x]
  (->> x
       (iterate #(quot % 10))
       (take-while pos?)
       (mapv #(mod % 10))
       rseq))

(defn adjacent?
  [xs]
  (->> xs
       (partition-by identity)
       (some #(>= (count %) 2))))

(defn increasing?
  [xs]
  (->> xs
       (partition 2 1)
       (every? #(apply <= %))))

(defn valid?
  [xs]
  (and (adjacent? xs)
       (increasing? xs)))

(defn part1
  []
  (let [[min max] fixture]
    (->> (range min (inc max))
         (map digits)
         (filter valid?)
         count)))
