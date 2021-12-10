(ns adventofcode.2021.day03
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

(defn parse
  [input]
  (->> input
       io/reader
       line-seq
       (map seq)))

(defn group-vertically
  [binaries]
  (apply map vector binaries))

(defn to-decimal
  [binary-seq]
  (Long/parseLong (str/join binary-seq) 2))

(defn most-common-bit
  [column]
  (->> (frequencies column)
       (sort-by val)
       last
       key))

(defn least-common-bit
  [column]
  (->> (frequencies column)
       (sort-by val)
       first
       key))

(defn part1
  [input]
  (let [parsed (parse input)
        grouped (group-vertically parsed)
        gamma (to-decimal (map most-common-bit grouped))
        epsilon (to-decimal (map least-common-bit grouped))]
    (* gamma epsilon)))
