(ns adventofcode.2019.day06
  (:require [clojure.java.io :as io]
            [clojure.string :as str]
            [clojure.set :as set]))

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

(defn orbit-parents
  [orbits planet]
  (->> planet
       (iterate (partial get orbits))
       (take-while some?)
       rest))

(defn orbit-transfers
  [orbits from to]
  (let [from-parents (set (orbit-parents orbits from))
        to-parents (set (orbit-parents orbits to))]
    (into (set/difference from-parents to-parents)
          (set/difference to-parents from-parents))))

(defn part1
  []
  (let [orbits (orbit-map fixture)]
    (->> orbits
         keys
         (map (partial orbit-parents orbits))
         (map count)
         (reduce +))))

(defn part2
  []
  (let [orbits (orbit-map fixture)]
    (count (orbit-transfers orbits "YOU" "SAN"))))
