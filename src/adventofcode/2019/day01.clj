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
      (quot 3)
      (- 2)))

(defn part1
  []
  (->> fixture
       (map fuel)
       (reduce +)))

(defn total-fuel
  "Fuel required to launch a mass and its fuel, etc.
  So, for each module mass, calculate its fuel and add it to the total. Then,
  treat the fuel amount you just calculated as the input mass and repeat the
  process, continuing until a fuel requirement is zero or negative."
  [mass]
  (loop [extra-mass mass
         total      0]
    (let [extra-fuel (fuel extra-mass)]
      (if-not (pos? extra-fuel)
        total
        (recur extra-fuel (+ total extra-fuel))))))

(defn part2
  []
  (->> fixture
       (map total-fuel)
       (reduce +)))
