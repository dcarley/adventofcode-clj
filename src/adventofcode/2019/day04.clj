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

(defn adjacent?
  [xs]
  (->> xs
       (partition-by identity)
       (some #(>= (count %) 2))))

(defn increasing?
  [xs]
  (->> xs
       (partition 2 1)
       (every? #(<= (apply compare %) 0))))

(defn valid?
  [xs]
  (and (increasing? xs)
       (adjacent? xs)))

(defn part1
  []
  (let [[min max] fixture]
    (->> (range min (inc max))
         (map str)
         (filter valid?)
         count)))
