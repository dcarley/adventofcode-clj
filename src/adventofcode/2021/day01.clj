(ns adventofcode.2021.day01
  (:require [clojure.java.io :as io]))

(defn parse
  [input]
  (->> input
       io/reader
       line-seq
       (map #(Integer/parseInt %))))

(defn depth-increases
  [input]
  (let [depths (parse input)]
    (reduce (fn [count [prev next]] (if (< prev next) (inc count) count))
            0
            (partition 2 1 depths))))
