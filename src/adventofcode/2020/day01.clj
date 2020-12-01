(ns adventofcode.2020.day01
  (:require [clojure.java.io :as io]
            [clojure.math.combinatorics :as combo]))

(defn parse
  [input]
  (->> input
       io/reader
       line-seq
       (map #(Integer/parseInt %))))

(defn find-sum
  [numbers]
  (let [pairs (combo/combinations numbers 2)
        match? #(= 2020 (apply + %))]
    (->> pairs
         (filter match?)
         first)))

(defn solve
  [input]
  (->> input
       parse
       find-sum
       (apply *)))
