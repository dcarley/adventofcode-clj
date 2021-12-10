(ns adventofcode.2021.day03-test
  (:require [clojure.test :refer :all]
            [adventofcode.2021.day03 :refer :all]
            [clojure.java.io :as io]))

(def part1-example
  (char-array "00100
11110
10110
10111
10101
01111
00111
11100
10000
11001
00010
01010"))

(deftest day03
  (testing "part1"
    (testing "example"
      (is (= 198 (part1 part1-example))))
    (testing "solution"
      (is (= 1092896 (part1 (io/resource "2021/day03")))))))
