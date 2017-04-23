(ns ui.views
    (:require [re-frame.core :as re-frame]
              [reagent-material-ui.core :refer [RaisedButton]]))


;; counter

(defn counter-panel []
  (let [c (re-frame/subscribe [:all-counters])]
    (fn []
      [:div (str "Testando" @c)
        [:button {:on-click #(re-frame/dispatch [:increment-counter c])} "Click me"]
        [RaisedButton {:label (str "Click to inc " @c) :primary true}]])))

;; home

(defn home-panel []
  (let [name (re-frame/subscribe [:name])]
    (fn []
      [:div (str "Hello from " @name ". This is the Home Page.")
       [:div [:a {:href "#/about"} "go to About Page"]]])))


;; about

(defn about-panel []
  (fn []
    [:div "This is the About Page."
     [:div [:a {:href "#/"} "go to Home Page"]]]))


;; main

(defn- panels [panel-name]
  (case panel-name
    :home-panel [home-panel]
    :about-panel [about-panel]
    :counter-panel [counter-panel]
    [:div]))

(defn show-panel [panel-name]
  [panels panel-name])

(defn main-panel []
  (let [active-panel (re-frame/subscribe [:active-panel])]
    (fn []
      [show-panel @active-panel])))
