;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;; Problem 1 ;;;;;;;;;;;;;
; Sum of numbers divisible by 3 or 5
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(ns euler.problem-1)
(println (apply + (filter #(or (zero? (rem % 3)) (zero? (rem % 5)))
  (range 1000))))
