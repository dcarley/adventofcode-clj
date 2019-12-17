(ns adventofcode.2019.day04-test
  (:require [clojure.test :refer :all]
            [adventofcode.2019.day04 :as day04]))

(deftest day04
  (testing "fixture"
    (is (= [206938 679128] day04/fixture)))

  (testing "adjacent? >="
    (is (= nil (day04/adjacent? >= [1 2 3 4 5 6])))
    (is (= true (day04/adjacent? >= [1 2 3 3 4 5])))
    (is (= true (day04/adjacent? >= [1 1 1 1 1 1]))))

  (testing "adjacent? ="
    (is (= nil (day04/adjacent? = [1 2 3 4 5 6])))
    (is (= true (day04/adjacent? = [1 2 3 3 4 5])))
    (is (= nil (day04/adjacent? = [1 1 1 1 1 1]))))

  (testing "increasing?"
    (is (= false (day04/increasing? [1 2 3 4 5 4])))
    (is (= false (day04/increasing? [1 2 1 2 1 2])))
    (is (= true (day04/increasing? [1 1 2 2 3 3])))
    (is (= true (day04/increasing? [1 2 3 4 5 6]))))

  (testing "part1 solution"
    (is (= 1653 (day04/part1))))

  (testing "part2 solution"
    (is (= 1133 (day04/part2)))))
