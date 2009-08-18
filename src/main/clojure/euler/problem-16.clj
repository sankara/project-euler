(ns euler.problem-16
  (:use clojure.contrib.math))
(def atoi #(Character/digit % 10))
(time (println (reduce + (map atoi (str (expt 2 1000))))))

; 1366
; "Elapsed time: 47.520765 msecs"
