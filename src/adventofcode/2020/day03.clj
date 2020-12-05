(ns adventofcode.2020.day03
  (:require [clojure.java.io :as io]))

(def tree \#)

(defn parse
  [input]
  (->> input
       io/reader
       line-seq))

(defn count-trees
  [[x-inc y-inc] lines]
  (let [x-max (count (first lines))
        y-max (count lines)]
    (loop [x 0
           y 0
           trees 0]
      (if (>= y y-max)
        trees
        (recur (mod (+ x-inc x) x-max)
               (+ y-inc y)
               (if (= tree (nth (nth lines y) x))
                 (inc trees)
                 trees))))))

(def starting-positions
  [[1 1]
   [3 1]
   [5 1]
   [7 1]
   [1 2]])

(defn part1
  [input]
  (->> input
      parse
      (count-trees (second starting-positions))))

(defn part2
  [input]
  (let [lines (parse input)]
    (->> starting-positions
         (map #(count-trees % lines))
         (reduce *))))
