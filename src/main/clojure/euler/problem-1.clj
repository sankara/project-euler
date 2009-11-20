;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;; Problem 1 ;;;;;;;;;;;;;
; Sum of numbers divisible by 3 or 5
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(ns euler.problem-1)
(println (time (reduce +
    (filter #(or (zero? (rem % 3)) (zero? (rem % 5)))
        (range 1000)))))

;"Elapsed time: 17.663241 msecs"
;233168
;
