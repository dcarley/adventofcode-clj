(ns adventofcode.2019.day02-test
  (:require [clojure.test :refer :all]
            [adventofcode.2019.day02 :as day02]))

(deftest day02
  (testing "part1 examples"
    (is (= [3500,9,10,70,2,3,11,0,99,30,40,50] (day02/execute [1,9,10,3,2,3,11,0,99,30,40,50])))
    (is (= [2,0,0,0,99] (day02/execute [1,0,0,0,99])))
    (is (= [2,3,0,6,99] (day02/execute [2,3,0,3,99])))
    (is (= [2,4,4,5,99,9801] (day02/execute [2,4,4,5,99,0])))
    (is (= [30,1,1,4,2,5,6,0,99] (day02/execute [1,1,1,4,99,5,6,0,99]))))

  (testing "part1 solution"
    (is (= 5290681 (day02/part1))))

  (testing "part2 examples"
    (is (= 5741 (day02/part2)))))
