(ns euler.problem-7)
(use 'clojure.contrib.lazy-seqs)
; Using the one provided by clojure itself.
(println (time (nth primes 10000)))

;"Elapsed time: 912.886615 msecs"
;104743
