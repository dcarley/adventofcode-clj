(ns adventofcode.2019.day02
  (:require [clojure.java.io :as io]
            [clojure.data.csv :as csv]))

(def fixture
  (->> "2019/day02"
      io/resource
      io/reader
      csv/read-csv
      first
      (mapv #(Integer/parseInt %))))

(defn op
  "Run an opcoce on two inputs.
  Halt (99) and unknown opcodes are handled upstream of this."
  [opcode x y]
  (condp = opcode
   1 (+ x y)
   2 (* x y)))

(defn deref-value
  "Deference a value from an address stored in at another address."
  [intcodes address]
  (nth intcodes (nth intcodes address)))

(defn instruction
  "Execute one instruction of the program."
  [intcodes address]
  (let [opcode (nth intcodes address)
        x      (deref-value intcodes (+ address 1))
        y      (deref-value intcodes (+ address 2))
        out    (nth intcodes (+ address 3))]
    (assoc intcodes out (op opcode x y))))

(defn execute
  "Keep executing instructions until we encounter an opcode greater than 2."
  [memory]
  (loop [intcodes memory
         address  0]
    (if (> (nth intcodes address) 2)
      intcodes
      (recur (instruction intcodes address) (+ address 4)))))

(defn restore-state
  [intcodes noun verb]
  (assoc intcodes
         1 noun
         2 verb))
  "Restore the gravity assist program (your puzzle input) to the '1202 program
  alarm' state it had just before the last computer caught fire. To do this,
  before running the program, replace position 1 with the value 12 and replace
  position 2 with the value 2."

(defn part1
  []
  (-> fixture
      (restore-state 12 2)
      execute
      first))
