(ns euler.problem-9)
(time (dorun (for [a (range 1 1000) b (range a 1000)]
  (let [c (- 1000 (+ a b))]
    (if (= (+ (* a a) (* b b)) (* c c)) (println a b c))))))

;200 375 425
;"Elapsed time: 1176.72584 msecs"
