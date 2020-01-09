(ns adventofcode.2019.day08-test
  (:require [clojure.test :refer :all]
            [adventofcode.2019.day08 :as day08]))

(deftest day08
  (testing "part1 solution"
    (is (= 2520 (day08/part1)))))
