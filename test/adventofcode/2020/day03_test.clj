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
      (is (= 7 (part1 example))))
    (testing "solution"
      (is (= 171 (part1 (io/resource "2020/day03"))))))
  (testing "part2"
    (testing "example"
      (is (= 336 (part2 example))))
    (testing "solution"
      (is (= 1206576000 (part2 (io/resource "2020/day03")))))))
