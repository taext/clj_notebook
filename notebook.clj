(ns notebook)

(defrecord Note [body tags date-created location])

(defn build-note [body-text tags date-created location]
    (->Note body-text tags date-created location))

(def my-note (build-note "Today cool things happened..." ["dagbog" "oktober"] "20191015" "Lejligheden, DK"))

(defn get-year [my-note]
    (let [date-string (:date-created my-note)] 
        (str (subs date-string 0 4))
    ))

(defn get-month [my-note]
    (def months {"01" "January" "02" "February" "03" "March" "04" "April" "05" "May" "06" "June" 
                 "07" "July" "08" "August" "09" "September" "10" "October" "11" "November" "12" "December"})
    (let [date-string (:date-created my-note)] 
        (def my-month (subs date-string 4 6))
        (months my-month)))

(defn get-day [my-note]
    (let [date-string (:date-created my-note)]
    (def my-day (subs date-string 6 8))
    (str my-day)))

(defn parse-date [my-note]
    (def day (get-day my-note))
    (def month (get-month my-note))
    (def year (get-year my-note))
    (def result-dict {:month month :day day :year year})
    (def result-string (str month " " day "th " year))
    [result-string result-dict]
    )

(defn main [body tags date-created location]
    (build-note body tags date-created location)
)
