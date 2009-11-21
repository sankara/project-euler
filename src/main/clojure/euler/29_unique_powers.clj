(ns euler.29-unique-powers)
(println
    (time (count (set (for [i (range 2 101) j (range 2 101)]
        (.pow (new BigDecimal i) j))))))

;"Elapsed time: 502.922965 msecs"
;9183
