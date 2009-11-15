(ns euler.48-sum-series)
(println (time (reduce #(+ %1 (.pow (new BigDecimal %2) %2)) (range 1 1001))))

;"Elapsed time: 228.893857 msecs"
;9110846700
