(ns adventofcode.2020.day02-test
  (:require [clojure.test :refer :all]
            [adventofcode.2020.day02 :refer :all]
            [clojure.java.io :as io]))

(def example
  (char-array "1-3 a: abcde
1-3 b: cdefg
2-9 c: ccccccccc"))

(deftest day02
  (testing "part1"
    (testing "example"
      (is (= 2 (solve valid-part1? example))))
    (testing "solution"
      (is (= 600 (solve valid-part1? (io/resource "2020/day02"))))))
  (testing "part2"
    (testing "example"
      (is (= 1 (solve valid-part2? example))))
    (testing "solution"
      (is (= 245 (solve valid-part2? (io/resource "2020/day02")))))))
