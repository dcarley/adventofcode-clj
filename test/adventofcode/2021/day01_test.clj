(ns adventofcode.2021.day01-test
  (:require [clojure.test :refer :all]
            [adventofcode.2021.day01 :refer :all]
            [clojure.java.io :as io]))

(def part1-example
  (char-array "199
200
208
210
200
207
240
269
260
263"))

(deftest day01
  (testing "part1"
    (testing "example"
      (is (= 7 (depth-increases part1-example))))
    (testing "solution"
      (is (= 1832 (depth-increases (io/resource "2021/day01")))))))
