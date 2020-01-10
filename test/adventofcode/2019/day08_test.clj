(ns adventofcode.2019.day08-test
  (:require [clojure.test :refer :all]
            [adventofcode.2019.day08 :as day08]))

(deftest day08
  (testing "part1 solution"
    (is (= 2520 (day08/part1))))

  (testing "part2 example"
    (is (= '(\0 \1 \1 \0) (day08/decode "0222112222120000" 2 2))))

  (testing "part2 solution"
    (is (= '("░▓▓▓▓░░░░▓▓░░▓▓▓▓░░▓░▓▓▓░"
             "░▓▓▓▓░▓▓▓▓░▓▓░▓▓▓▓░▓░▓▓▓░"
             "░▓▓▓▓░░░▓▓░▓▓▓▓▓▓▓░▓▓░▓░▓"
             "░▓▓▓▓░▓▓▓▓░▓░░▓▓▓▓░▓▓▓░▓▓"
             "░▓▓▓▓░▓▓▓▓░▓▓░▓░▓▓░▓▓▓░▓▓"
             "░░░░▓░░░░▓▓░░░▓▓░░▓▓▓▓░▓▓")
           (day08/part2)))))
