(ns adventofcode.2020.day01-test
  (:require [clojure.test :refer :all]
            [adventofcode.2020.day01 :refer :all]
            [clojure.java.io :as io]))

(def part1-example
  (char-array "1721
979
366
299
675
1456"))

(deftest day01
  (testing "part1"
    (testing "example"
      (is (= [1721 299] (find-sum 2 (parse part1-example))))
      (is (= 514579 (solve 2 part1-example))))
    (testing "solution"
      (is (= 1020036 (solve 2 (io/resource "2020/day01"))))))
  (testing "part2"
    (testing "example"
      (is (= [979 366 675] (find-sum 3 (parse part1-example))))
      (is (= 241861950 (solve 3 part1-example))))
    (testing "solution"
      (is (= 286977330 (solve 3 (io/resource "2020/day01")))))))
