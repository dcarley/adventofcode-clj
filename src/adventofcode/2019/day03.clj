(ns adventofcode.2019.day03
  (:require [clojure.java.io :as io]
            [clojure.data.csv :as csv]
            [clojure.set :as set]))

(def fixture (io/resource "2019/day03"))

(defn move-once
  [direction position]
  (let [[x y] position]
    (case direction
      "U" [x (inc y)]
      "D" [x (dec y)]
      "L" [(dec x) y]
      "R" [(inc x) y])))

(defn parse-instruction
  [instruction]
  [(subs instruction 0 1)
   (Integer/parseInt (subs instruction 1))])

(defn move-line
  [instruction position]
  (let [[direction steps] (parse-instruction instruction)]
    (->> position
         (iterate (partial move-once direction))
         (take (inc steps))
         rest)))

(defn move-wire
  [instructions]
  (loop [remaining instructions
         positions [[0 0]]]
    (if (empty? remaining)
      (rest positions)
      (recur (rest remaining)
             (into positions (move-line (first remaining)
                                        (last positions)))))))

(defn manhattan-distance
  [a b]
  (let [[ax ay] a
        [bx by] b]
    (+ (Math/abs(- ax bx))
       (Math/abs(- ay by)))))

(defn nearest-intersection
  [input]
  (->> input
       io/reader
       csv/read-csv
       (map move-wire)
       (map set)
       (apply set/intersection)
       (map (partial manhattan-distance [0 0]))
       (apply min)))

(defn part1
  []
  (nearest-intersection fixture))
