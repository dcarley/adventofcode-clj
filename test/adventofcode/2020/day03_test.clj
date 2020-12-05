(ns adventofcode.2020.day03-test
  (:require [clojure.test :refer :all]
            [adventofcode.2020.day03 :refer :all]
            [clojure.java.io :as io]))

(def example
  (char-array "..##.......
#...#...#..
.#....#..#.
..#.#...#.#
.#...##..#.
..#.##.....
.#.#.#....#
.#........#
#.##...#...
#...##....#
.#..#...#.#"))

(deftest day03
  (testing "part1"
    (testing "example"
      (is (= 7 (solve example))))
    (testing "solution"
      (is (= 171 (solve (io/resource "2020/day03")))))))
