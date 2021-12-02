(ns adventofcode.2021.day01
  (:require [clojure.java.io :as io]))

(defn parse
  [input]
  (->> input
       io/reader
       line-seq
       (map #(Integer/parseInt %))))

(defn depth-single-increases
  [input]
  (let [depths (parse input)]
    (reduce (fn [count [prev next]]
              (if (< prev next)
                (inc count)
                count))
            0 (partition 2 1 depths))))

(defn depth-window-increases
  [input]
  (let [depths (parse input)]
    (reduce (fn [count values]
              (let [prev-window (apply + (take 3 values))
                    next-window (apply + (drop 1 values))]
                (if (< prev-window next-window)
                  (inc count)
                  count)))
            0 (partition 4 1 depths))))
