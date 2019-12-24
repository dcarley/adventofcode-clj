(ns adventofcode.2019.day06
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

(def fixture
  (-> "2019/day06"
      io/resource
      io/reader
      line-seq))

(defn orbit-entry
  [line]
  (let [[parent child] (str/split line #"\)")]
    {child parent}))

(defn orbit-map
  [lines]
  (->> lines
       (map orbit-entry)
       (into (sorted-map))))

(defn count-parents
  [orbits planet]
  (loop [parent planet
         count 0]
    (if (= parent "COM")
      count
      (recur (get orbits parent) (inc count)))))

(defn part1
  []
  (let [orbits (orbit-map fixture)]
    (->> orbits
         keys
         (map (partial count-parents orbits))
         (reduce +))))
