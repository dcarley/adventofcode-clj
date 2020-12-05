(ns adventofcode.2020.day03
  (:require [clojure.java.io :as io]))

(def tree \#)

(defn parse
  [input]
  (->> input
       io/reader
       line-seq))

(defn count-trees
  [lines]
  (let [x-max (count (first lines))
        y-max (count lines)]
    (loop [x 0
           y 0
           trees 0]
      (if (>= y y-max)
        trees
        (recur (mod (+ 3 x) x-max)
               (inc y)
               (if (= tree (nth (nth lines y) x))
                 (inc trees)
                 trees))))))

(defn solve
  [input]
  (-> input
      parse
      count-trees))
