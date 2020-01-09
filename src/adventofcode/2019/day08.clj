(ns adventofcode.2019.day08
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

(def fixture
  (-> "2019/day08"
      io/resource
      io/reader
      slurp
      str/trim-newline))

(def layer-size (* 25 6))

(defn checksum
  [freqs]
  (* (get freqs \1)
     (get freqs \2)))

(defn verify
  [image]
  (->> image
       (partition layer-size)
       (map frequencies)
       (sort-by #(get % \0) <)
       first
       checksum))

(defn part1
  []
  (verify fixture))
