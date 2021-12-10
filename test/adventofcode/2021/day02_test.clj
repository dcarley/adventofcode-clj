(ns adventofcode.2021.day02-test
  (:require [clojure.test :refer :all]
            [adventofcode.2021.day02 :refer :all]
            [clojure.java.io :as io]))

(def part1-example
  (char-array "forward 5
down 5
forward 8
up 3
down 8
forward 2"))

(deftest day02
  (testing "part1"
    (testing "example"
      (is (= 150 (part1 part1-example))))
    (testing "solution"
      (is (= 1561344 (part1 (io/resource "2021/day02"))))))
  (testing "part2"
    (testing "example"
      (is (= 900 (part2 part1-example))))
    (testing "solution"
      (is (= 1848454425 (part2 (io/resource "2021/day02")))))))
