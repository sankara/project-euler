(ns main.clojure.misc.fizz-buzz)

(println
  (map #(cond
          (zero? (mod % 15)) "FizzBuzz"
          (zero? (mod % 3)) "Fizz"
          (zero? (mod % 5)) "Buzz"
          :else %)
       (range 1 101)))

