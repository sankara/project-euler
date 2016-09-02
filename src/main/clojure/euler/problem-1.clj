;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;; Problem 1 ;;;;;;;;;;;;;
; Sum of numbers divisible by 3 or 5
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(ns euler.problem-1)
(doseq [ln (line-seq (java.io.BufferedReader. *in*))]
  (println (reduce +
    (filter #(or (zero? (rem % 3)) (zero? (rem % 5)))
        (range ln)))))

;"Elapsed time: 17.663241 msecs"
;233168
;
