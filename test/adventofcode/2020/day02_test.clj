(ns adventofcode.2020.day02-test
  (:require [clojure.test :refer :all]
            [adventofcode.2020.day02 :refer :all]
            [clojure.java.io :as io]))

(def part1-example
  (char-array "1-3 a: abcde
1-3 b: cdefg
2-9 c: ccccccccc"))

(deftest day02
  (testing "part1"
    (testing "example"
      (is (= 2 (solve part1-example))))
    (testing "solution"
      (is (= 600 (solve (io/resource "2020/day02")))))))
