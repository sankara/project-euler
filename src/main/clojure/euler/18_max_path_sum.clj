(ns euler.18-max-path-sum)

(def max-path-cache (ref '{}))

(defn cache-result [co-ord result]
    (do (dosync (alter max-path-cache conj {co-ord result}))) result)

(defn max-path-sum
    ([triangle]
        (do (dosync (ref-set max-path-cache '{}))
            (max-path-sum triangle [0 0])))

    ([triangle [rootx rooty]]
        (if (contains? @max-path-cache [rootx rooty]) (get @max-path-cache [rootx rooty])
            (cache-result [rootx rooty] (let [curr (nth (nth triangle rootx) rooty)]
                (if (>= (inc rootx) (count triangle)) curr
                    (let [
                        next-x (inc rootx)
                        next-y (inc rooty)
                        next-len (count (nth triangle next-x))
                        left-max (if (>= rooty 0) (max-path-sum triangle [next-x rooty]))
                        right-max (if (< rooty next-len) (max-path-sum triangle [next-x next-y]))]
                        (+ curr (max left-max right-max)))))))))

(def triangle [[75]
               [95 64]
               [17 47 82]
               [18 35 87 10]
               [20 4 82 47 65]
               [19 1 23 75 3 34]
               [88 2 77 73 7 63 67]
               [99 65 4 28 6 16 70 92]
               [41 41 26 56 83 40 80 70 33]
               [41 48 72 33 47 32 37 16 94 29]
               [53 71 44 65 25 43 91 52 97 51 14]
               [70 11 33 28 77 73 17 78 39 68 17 57]
               [91 71 52 38 17 14 91 43 58 50 27 29 48]
               [63 66 4 68 89 53 67 30 73 16 69 87 40 31]
               [4 62 98 27 23 9 70 98 73 93 38 53 60 4 23]])

(println (time (max-path-sum triangle)))

;"Elapsed time: 21.970655 msecs"
;1074
