;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;; Problem 1 ;;;;;;;;;;;;;
; Sum of numbers divisible by 3 or 5
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(ns euler.problem-1)
(let [n (Integer/parseInt (read-line))]
  (dotimes [_ n]
    (println (reduce +
      (filter #(or (zero? (rem % 3)) (zero? (rem % 5)))
        (range (Integer/parseInt (read-line))))))))

;"Elapsed time: 17.663241 msecs"
;233168
;
