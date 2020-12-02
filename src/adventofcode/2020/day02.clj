(ns adventofcode.2020.day02
  (:require [clojure.java.io :as io]))

(defn parse-line
  [line]
  (let [[_ pmin pmax pchar pass] (re-matches #"(\d+)-(\d+) (\w): (\w+)" line)]
    {:min (Integer/parseInt pmin)
     :max (Integer/parseInt pmax)
     :char (first pchar)
     :pass (frequencies pass)}))

(defn parse
  [input]
  (->> input
       io/reader
       line-seq
       (map parse-line)))

(defn valid?
  [entry]
  (<= (:min entry)
      (get (:pass entry)
           (:char entry)
           0)
      (:max entry)))

(defn solve
  [input]
  (-> input
      parse
      (filter valid?)
      count))
