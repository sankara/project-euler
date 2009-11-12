(ns euler.25-fib-100-dig)

(println (time
    (loop [i 1 f1 1 f2 1]
        (if (= (count (str f1)) 1000) i
            (recur (inc i) f2 (+ f1 f2))))))

;"Elapsed time: 1210.357499 msecs"
;4782
