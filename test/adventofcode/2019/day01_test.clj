(ns adventofcode.2019.day01-test
  (:require [clojure.test :refer :all]
            [adventofcode.2019.day01 :as day01]))

(deftest day01
  (testing "part1 examples"
    (is (= 2 (day01/fuel 12)))
    (is (= 2 (day01/fuel 14)))
    (is (= 654 (day01/fuel 1969)))
    (is (= 33583 (day01/fuel 100756))))

  (testing "part1 solution"
    (is (= 3373568 (day01/part1)))))
