package org.pondar.pacmankotlin

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.widget.TextView
import java.util.ArrayList


/**
 *
 * This class should contain all your game logic
 */

class Game(private var context: Context,view: TextView) {

        private var pointsView: TextView = view
        private var points : Int = 0
        //bitmap of the pacman
        var pacBitmap: Bitmap
        var coin: Bitmap
        var pacx: Int = 0
        var pacy: Int = 0

        //did we initialize the coins?
        var coinsInitialized = false

        //the list of goldcoins - initially empty
        var coins = ArrayList<GoldCoin>()

        //a reference to the gameview
        private var gameView: GameView? = null
        private var h: Int = 0
        private var w: Int = 0 //height and width of screen


    //The init code is called when we create a new Game class.
    //it's a good place to initialize our images.
    init {
        pacBitmap = BitmapFactory.decodeResource(context.resources, R.drawable.pacman)
        coin = BitmapFactory.decodeResource(context.resources, R.drawable.goldcoin)
    }

    fun setGameView(view: GameView) {
        this.gameView = view
    }

    //TODO initialize goldcoins also here
    fun initializeGoldcoins()
    {
        //DO Stuff to initialize the array list with some coins.
        val coin1 = GoldCoin(150, 250, false)
        val coin2 = GoldCoin(350, 150, false)
        val coin3 = GoldCoin(50, 75, false)
        val coin4 = GoldCoin(250, 175, false)
        val coin5 = GoldCoin(450, 100, false)
        val coin6 = GoldCoin(550, 325, false)
        val coin7 = GoldCoin(175, 260, false)
        val coin8 = GoldCoin(190, 565, false)
        val coin9 = GoldCoin(90, 245, false)
        val coin10 = GoldCoin(145, 335, false)

        coins.add(coin1)
        coins.add(coin2)
        coins.add(coin3)
        coins.add(coin4)
        coins.add(coin5)
        coins.add(coin6)
        coins.add(coin7)
        coins.add(coin8)
        coins.add(coin9)
        coins.add(coin10)

        coinsInitialized = true
    }


    fun newGame() {
        pacx = 50
        pacy = 400 //just some starting coordinates - you can change this.
        //reset the points
        coinsInitialized = false
        points = 0
        pointsView.text = "${context.resources.getString(R.string.points)} $points"
        gameView?.invalidate() //redraw screen
    }

    fun setSize(h: Int, w: Int) {
        this.h = h
        this.w = w
    }

    fun movePacmanRight(pixels: Int) {
        //still within our boundaries?
        if (pacx + pixels + pacBitmap.width < w) {
            pacx = pacx + pixels
            doCollisionCheck()
            gameView?.invalidate()
        }
    }

    fun movePacmanLeft(pixels: Int) {
        //still within our boundaries?
        if (pacx - pixels > 0) {
            pacx = pacx - pixels
            doCollisionCheck()
            gameView?.invalidate()
        }
    }

    fun movePacmanUp(pixels: Int) {
        //still within our boundaries?
        if (pacy + pixels > 0) {
            pacy = pacy - pixels
            doCollisionCheck()
            gameView?.invalidate()
        }
    }

    fun movePacmanDown(pixels: Int) {
        //still within our boundaries?
        if (pacy + pixels + pacBitmap.height < h) {
            pacy = pacy + pixels
            doCollisionCheck()
            gameView?.invalidate()
        }
    }

    //TODO check if the pacman touches a gold coin
    //and if yes, then update the neccesseary data
    //for the gold coins and the points
    //so you need to go through the arraylist of goldcoins and
    //check each of them for a collision with the pacman
    fun doCollisionCheck() {

    }

    fun distance(x1:Int, y1:Int, x2:Int, y2:Int) : Float {
        // calculate distance and return it

    }



}