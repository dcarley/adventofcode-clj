(ns adventofcode.2020.day02
  (:require [clojure.java.io :as io]))

(defn parse-line
  [line]
  (let [[_ a b char pass] (re-matches #"(\d+)-(\d+) (\w): (\w+)" line)]
    {:a (Integer/parseInt a)
     :b (Integer/parseInt b)
     :char (first char)
     :pass pass}))

(defn parse
  [input]
  (->> input
       io/reader
       line-seq
       (map parse-line)))

(defn valid-part1?
  [entry]
  (let [min (:a entry)
        max (:b entry)
        freqs (frequencies (:pass entry))]
    (<= min
        (get freqs (:char entry) 0)
        max)))

(defn valid-part2?
  [entry]
  (let [pass (:pass entry)
        a (nth pass (dec (:a entry)))
        b (nth pass (dec (:b entry)))
        char (:char entry)]
    (and (not= a b)
         (or (= a char)
             (= b char)))))

(defn solve
  [valid? input]
  (->> input
       parse
       (filter valid?)
       count))
