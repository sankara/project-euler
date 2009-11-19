(ns euler.28)

; Right diagonal would be
;   1 5 9 17 25
; Pattern f(i) = f(i - 1) + (int) (i / 2) *  4 where f(1) =  1
(defn elem-diag-right [i]
    (if (= i 1) 1 (+ (elem-diag-right (dec i)) (* 4 (int (/ i 2))))))

; Left diagonal would be
;   1 3 7 13 21
; Pattern f(i) = f(i - 1) + (i - 1) * 2 where f(1) = 1
(defn elem-diag-left [i]
    (if (= i 1) 1 (+ (elem-diag-left (dec i)) (* (dec i) 2))))

(defn sum-diag [n]
    (dec (reduce + (for [i (range 1 (inc n))] (+ (elem-diag-left i) (elem-diag-right i))))))

(println (time (sum-diag 1001)))

;"Elapsed time: 2818.221229 msecs"
;669171001

(comment
    (assert (= 9 (elem-diag-right 3)))
    (assert (= 17 (elem-diag-right 4)))
    (assert (= 25 (elem-diag-right 5)))
    (assert (= 49 (elem-diag-right 7)))
    (assert (= 3 (elem-diag-left 2)))
    (assert (= 21 (elem-diag-left 5)))
    (assert (= 43 (elem-diag-left 7)))
    (assert (= 101 (sum-diag 5))))

; 7 x 7 spiral
;   43 44 45 46 47 48 49
;   42 21 22 23 24 25 26
;   41 20 07 08 09 10 27
;   40 19 06 01 02 11 28
;   39 18 05 04 03 12 29
;   38 17 16 15 14 13 30
;   37 36 35 34 33 32 31
