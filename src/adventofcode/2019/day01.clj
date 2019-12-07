(ns adventofcode.2019.day01
  (:require [clojure.java.io :as io]))

(def fixture
  (->> "2019/day01"
       io/resource
       io/reader
       line-seq
       (map #(Integer/parseInt %))))

(defn fuel
  "Fuel required to launch a given module is based on its mass.
  Specifically, to find the fuel required for a module, take its mass, divide by
  three, round down, and subtract 2."
  [mass]
  (-> mass
      (/ 3)
      Math/floor
      int
      (- 2)))

(defn part1
  []
  (->> fixture
       (map fuel)
       (reduce +)))
