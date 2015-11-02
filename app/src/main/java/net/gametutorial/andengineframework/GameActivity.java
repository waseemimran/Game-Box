package net.gametutorial.andengineframework;

import android.graphics.Typeface;
import android.view.Display;
import android.widget.Toast;

import org.andengine.audio.music.Music;
import org.andengine.audio.music.MusicFactory;
import org.andengine.engine.camera.Camera;
import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.engine.handler.timer.ITimerCallback;
import org.andengine.engine.handler.timer.TimerHandler;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.FillResolutionPolicy;
import org.andengine.entity.Entity;
import org.andengine.entity.IEntity;
import org.andengine.entity.modifier.LoopEntityModifier;
import org.andengine.entity.modifier.MoveByModifier;
import org.andengine.entity.modifier.PathModifier;
import org.andengine.entity.modifier.SequenceEntityModifier;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.CameraScene;
import org.andengine.entity.scene.IOnAreaTouchListener;
import org.andengine.entity.scene.IOnSceneTouchListener;
import org.andengine.entity.scene.ITouchArea;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.AutoParallaxBackground;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.scene.background.ParallaxBackground;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.entity.text.TextOptions;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.font.Font;
import org.andengine.opengl.font.FontFactory;
import org.andengine.opengl.texture.ITexture;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.andengine.opengl.texture.atlas.buildable.builder.BlackPawnTextureAtlasBuilder;
import org.andengine.opengl.texture.atlas.buildable.builder.ITextureAtlasBuilder;
import org.andengine.opengl.texture.bitmap.AssetBitmapTexture;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.TextureRegionFactory;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import org.andengine.opengl.util.GLState;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.ui.activity.BaseGameActivity;
import org.andengine.util.adt.align.HorizontalAlign;
import org.andengine.util.adt.color.Color;
import org.andengine.util.debug.Debug;
import org.andengine.util.modifier.ease.EaseSineInOut;

import java.io.IOException;

public class GameActivity extends BaseGameActivity  implements ButtonSprite.OnClickListener,IOnSceneTouchListener               {
    private int CAMERA_WIDTH1;
    private int CAMERA_HEIGHT1;
    private static final int CAMERA_WIDTH = 840;
    private static final int CAMERA_HEIGHT = 480;
    private ITexture mFaceTexture;
    private Camera camera;
    private CameraScene mPauseScene;
    private Scene splashScene;
    private Scene mainScene,  thirdScreen, GameEndScreen,myscene;
    private static final int RECTANGLE_SIZE = 50;
  //  private BitmapTextureAtlas splashTextureAtlas;
    private ITextureRegion splashTextureRegion;
    private Sprite splash,restartButton,homeButton;
    private ITexture splashTextureAtlas;
    private ITextureRegion mFaceTextureRegion;
    Display mDisplay;
    private BuildableBitmapTextureAtlas mBuildableBitmapTextureAtlas;
    private ITextureRegion mButtonNormalTextureRegion;
    private ITextureRegion mPressedTextureRegion;
    private ITextureRegion mDisabledTextureRegion;
    private ITexture mNotesTexture,mBoxSecond,mBoxThirdTexture,mBoxForthTexture,mBoxFifthTexture,mfirstBoxTexure;
    private ITextureRegion mNotesTextureRegion,mBoxSecondRegion,mBoxthirdRegion,mBoxForthReagion,mBoxFifthRegion,mBoxFirstRegion;
    private ITexture mquiTexture,mHomeTexture,mRestrartTextrue;
    private ITextureRegion mquittextureRegion,mHomeTextrueRegin,mRestartTextureRegion,mTopEendTextureRegion,mTopEendTextureRegion2;
    private ITexture mPlayerTexture,mTopEendTexture,mTopEendTexture2,mTopEendTexture3;
    private TiledTextureRegion mPlayerTextureRegion;
    private TiledTextureRegion mPlayerTextureRegion1,mTopEendTextureRegion3;
    private ITexture mParallaxLayerBackTexture,mParallaxLayercloud;
    private ITexture mParallaxLayerMidTexture;
    private ITexture mParallaxLayerFrontTexture;
     VertexBufferObjectManager vertexBufferObjectManager;
    private ITextureRegion mParallaxLayerBackTextureRegion;
    private ITextureRegion mParallaxLayerMidTextureRegion,mParallaxLayercloudTextureRegion;
    private ITextureRegion mParallaxLayerFrontTextureRegion;
    private Font mFont;
    int count=0;
    Text mHudText;
    Sprite mFirstBox, mSecondBox,mThirdBox,mForthBox,mFifthBox, mTopEndButton,mTopEndButton2,mTopEndButton3;
    AnimatedSprite player;
    private Music mMusic;


    @Override
    public void onClick(ButtonSprite pButtonSprite1, float pTouchAreaLocalX, float pTouchAreaLocalY) {
        //music();
        this.toastOnUiThread("GO..GO..GO", Toast.LENGTH_LONG);
         vertexBufferObjectManager = this.getVertexBufferObjectManager();
        thirdScreen = new Scene();
        final float centerX = CAMERA_WIDTH / 12;
        final float centerY = CAMERA_HEIGHT / 18;
        player = new AnimatedSprite(centerX, centerY , this.mPlayerTextureRegion, vertexBufferObjectManager);
        //player.setOffsetCenterY(0);
      //  player.setScale(2);
     //   player.animate(new long[]{200, 200, 200}, 3, 5, true);
//
//        mTopEndButton = new Sprite(70, 420, this.mTopEendTextureRegion, this.getVertexBufferObjectManager());
//        mTopEndButton.setScale(1);
//        //thirdScreen.registerTouchArea( mTopEndButton);
//        //thirdScreen.attachChild( mTopEndButton);

        mFirstBox = new Sprite(CAMERA_WIDTH-2, 13, this.mBoxFirstRegion, this.getVertexBufferObjectManager());
        mFirstBox.setScale(1);
        thirdScreen.registerTouchArea(mFirstBox);
        thirdScreen.attachChild(mFirstBox);

         mSecondBox = new Sprite(CAMERA_WIDTH-2, 130, this.mBoxSecondRegion, this.getVertexBufferObjectManager());
        mSecondBox.setScale(1);
        thirdScreen.registerTouchArea(mSecondBox);
        thirdScreen.attachChild(mSecondBox);

        mThirdBox = new Sprite(-10, 200, this.mBoxthirdRegion, this.getVertexBufferObjectManager());
        mThirdBox.setScale(1);
        thirdScreen.registerTouchArea(mThirdBox);
        thirdScreen.attachChild(mThirdBox);

        mForthBox = new Sprite(-12, 320, this.mBoxForthReagion, this.getVertexBufferObjectManager());
        mForthBox.setScale(1);
        thirdScreen.registerTouchArea(mForthBox );
        thirdScreen.attachChild(mForthBox);

        mFifthBox = new Sprite(-12, 420, this.mBoxFifthRegion, this.getVertexBufferObjectManager());
        mFifthBox.setScale(1);
        thirdScreen.registerTouchArea( mFifthBox  );
        thirdScreen.attachChild(mFifthBox );

      //  HUD gameHUD = new HUD();
        // CREATE SCORE c
        mHudText = new Text(-12, 460, GameActivity.this.mFont, "0123456789", new TextOptions(HorizontalAlign.LEFT), vertexBufferObjectManager);
        mHudText.setText("Score:0");
        mHudText.setX((CAMERA_WIDTH - mHudText.getWidth()) / 10);
        mHudText.setVisible(true);
      //  gameHUD.attachChild(mHudText);
        //camera.setHUD(gameHUD);
        thirdScreen.attachChild(mHudText);
        thirdScreen.registerTouchArea(player);
        thirdScreen.attachChild(player);
        thirdScreen.setOnSceneTouchListener(this);



        mTopEndButton = new Sprite(12, 460, this.mTopEendTextureRegion, this.getVertexBufferObjectManager()){
            @Override
            public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {

               // if (mEngine.isRunning()) {
                  //  pauseGame();
                //} else {
                   // unPauseGame();
                //}
//                mTopEndButton.setVisible(false);
//                mTopEndButton2.setVisible(true);

                return true;
            }
        };
        mTopEndButton.setScale(1);
        thirdScreen.registerTouchArea(mTopEndButton);
       // thirdScreen.attachChild(mTopEndButton);

        final AutoParallaxBackground autoParallaxBackground = new AutoParallaxBackground(0, 0, 0, 10);
        final Sprite parallaxLayerBackSprite = new Sprite(0, 0, this.mParallaxLayerBackTextureRegion, vertexBufferObjectManager);
        parallaxLayerBackSprite.setOffsetCenter(0, 0);
        autoParallaxBackground.attachParallaxEntity(new ParallaxBackground.ParallaxEntity(-3.0f, parallaxLayerBackSprite));

        final Sprite parallaxLayerMidSprite = new Sprite(0, CAMERA_HEIGHT - this.mParallaxLayerMidTextureRegion.getHeight() - 70, this.mParallaxLayerMidTextureRegion, vertexBufferObjectManager);
        parallaxLayerMidSprite.setOffsetCenter(0, 0);
        autoParallaxBackground.attachParallaxEntity(new ParallaxBackground.ParallaxEntity(-2.0f, parallaxLayerMidSprite));

        final Sprite parallaxLayerBackCloudSprite = new Sprite(0, 0, this.mParallaxLayercloudTextureRegion, vertexBufferObjectManager);
        parallaxLayerBackCloudSprite.setOffsetCenter(0, 0);
        autoParallaxBackground.attachParallaxEntity(new ParallaxBackground.ParallaxEntity(-10.0f, parallaxLayerBackCloudSprite));

        final PathModifier.Path path = new PathModifier.Path(2).to(CAMERA_WIDTH - 2, 40).to(-20, 40);
        final PathModifier.Path secondBoxPath = new PathModifier.Path(2).to(CAMERA_WIDTH-2, 120).to(-20, 120);
        final PathModifier.Path thirdBoxPath = new PathModifier.Path(2).to(CAMERA_WIDTH-3, 200).to(-20,200);
        final PathModifier.Path forthBoxPath = new PathModifier.Path(2).to(CAMERA_WIDTH-3, 320).to(-20,320);
        final PathModifier.Path fifthBoxPath = new PathModifier.Path(2).to(CAMERA_WIDTH-3, 420).to(-20,420);

        mFifthBox.registerEntityModifier(new LoopEntityModifier(new PathModifier(13, fifthBoxPath, null, new PathModifier.IPathModifierListener() {
            @Override
            public void onPathStarted(PathModifier pPathModifier, IEntity pEntity) {
            }

            @Override
            public void onPathWaypointStarted(PathModifier pPathModifier, IEntity pEntity, int pWaypointIndex) {
            }

            @Override
            public void onPathWaypointFinished(PathModifier pPathModifier, IEntity pEntity, int pWaypointIndex) {

            }

            @Override
            public void onPathFinished(PathModifier pPathModifier, IEntity pEntity) {
                countScore();
            }
        }, EaseSineInOut.getInstance())));

        mForthBox.registerEntityModifier(new LoopEntityModifier(new PathModifier(5 ,forthBoxPath,null, new PathModifier.IPathModifierListener() {
            @Override
            public void onPathStarted(PathModifier pPathModifier, IEntity pEntity) {
            }
            @Override
            public void onPathWaypointStarted(PathModifier pPathModifier, IEntity pEntity, int pWaypointIndex) {
            }
            @Override
            public void onPathWaypointFinished(PathModifier pPathModifier, IEntity pEntity, int pWaypointIndex) {

            }

            @Override
            public void onPathFinished(PathModifier pPathModifier, IEntity pEntity) {
                countScore();
            }
        }, EaseSineInOut.getInstance())));

        mThirdBox.registerEntityModifier(new LoopEntityModifier(new PathModifier(10 ,thirdBoxPath,null, new PathModifier.IPathModifierListener() {
            @Override
            public void onPathStarted(PathModifier pPathModifier, IEntity pEntity) {
            }
            @Override
            public void onPathWaypointStarted(PathModifier pPathModifier, IEntity pEntity, int pWaypointIndex) {
            }
            @Override
            public void onPathWaypointFinished(PathModifier pPathModifier, IEntity pEntity, int pWaypointIndex) {

            }

            @Override
            public void onPathFinished(PathModifier pPathModifier, IEntity pEntity) {
                countScore();
            }
        }, EaseSineInOut.getInstance())));

        mSecondBox.registerEntityModifier(new LoopEntityModifier(new PathModifier(7 ,secondBoxPath,null, new PathModifier.IPathModifierListener() {
            @Override
            public void onPathStarted(PathModifier pPathModifier, IEntity pEntity) {
            }
            @Override
            public void onPathWaypointStarted(PathModifier pPathModifier, IEntity pEntity, int pWaypointIndex) {
            }
            @Override
            public void onPathWaypointFinished(PathModifier pPathModifier, IEntity pEntity, int pWaypointIndex) {

            }

            @Override
            public void onPathFinished(PathModifier pPathModifier, IEntity pEntity) {
                countScore();
            }
        }, EaseSineInOut.getInstance())));

        mFirstBox.registerEntityModifier(new LoopEntityModifier(new PathModifier(15, path, null, new PathModifier.IPathModifierListener() {
            @Override
            public void onPathStarted(final PathModifier pPathModifier, final IEntity pEntity) {
                Debug.d("onPathStarted");
            }

            @Override
            public void onPathWaypointStarted(PathModifier pPathModifier, IEntity pEntity, int pWaypointIndex) {
            }

            @Override
            public void onPathWaypointFinished(final PathModifier pPathModifier, final IEntity pEntity, final int pWaypointIndex) {
                Debug.d("onPathWaypointFinished: " + pWaypointIndex);
            }

            @Override
            public void onPathFinished(final PathModifier pPathModifier, final IEntity pEntity) {
                Debug.d("onPathFinished");
                countScore();
            }
        }, EaseSineInOut.getInstance())));
        thirdScreen.registerUpdateHandler(new IUpdateHandler() {

            @Override
            public void onUpdate(float pSecondsElapsed) {
               if (mFirstBox.collidesWith(player) || mSecondBox.collidesWith(player) || mThirdBox.collidesWith(player) || mForthBox.collidesWith(player) || mFifthBox.collidesWith(player)) {
                    GameEndScreen = new Scene();
                    final Text centerText = new Text(CAMERA_WIDTH / 2, 400, GameActivity.this.mFont, "GAME OVER !!!\n" + "Your Score is:" + count, new TextOptions(HorizontalAlign.CENTER), vertexBufferObjectManager);
                    //thirdScreen.reset();
                   count=0;
                    homeButton = new Sprite(380, 250, GameActivity.this.mHomeTextrueRegin, GameActivity.this.getVertexBufferObjectManager()) {
                        @Override
                        public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {

                            mEngine.setScene(mainScene);
                            return true;
                        }
                    };
                    GameEndScreen.registerTouchArea(homeButton);
                    GameEndScreen.attachChild(homeButton);
                    restartButton = new Sprite(450, 250, GameActivity.this.mRestartTextureRegion, GameActivity.this.getVertexBufferObjectManager()){
                        @Override
                        public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {

                            mEngine.setScene(thirdScreen);
                            thirdScreen.resetScaleCenter();
                            return true;
                        }
                    };
                    GameEndScreen.registerTouchArea(restartButton);
                    GameEndScreen.attachChild(restartButton);
                    GameEndScreen.attachChild(centerText);
                    GameEndScreen.setBackground(new Background(Color.WHITE));
                    mEngine.setScene(GameEndScreen);

                }
            }

            @Override
            public void reset() {

            }
        });
        thirdScreen.setBackground(autoParallaxBackground);
       // mainScene2.setBackground(new Background(Color.BLUE));
        mEngine.setScene( thirdScreen);
    }


    private void playerMove(){
        final Entity playerEntity = player;
        final SequenceEntityModifier modifier1 = new SequenceEntityModifier(
                new MoveByModifier((float) 1.0, 0, 30),
                new MoveByModifier((float) 1.5, 0, -30)
        );

//        if(player.contains(70,460)){
//          //  player.setVisible(false);
//         Debug.d("onPathWaypointFinished: " );
//        }
        playerEntity.registerEntityModifier(modifier1);

    }
    @Override
    public boolean onSceneTouchEvent(Scene pScene, TouchEvent pSceneTouchEvent) {
        playerMove();
        return true;
    };
    private enum SceneType {
        SPLASH,
        MAIN,
    }
    private SceneType currentScene = SceneType.SPLASH;
    @Override
    public EngineOptions onCreateEngineOptions() {

        mDisplay = getWindowManager().getDefaultDisplay();
        mDisplay = getWindowManager().getDefaultDisplay();

        CAMERA_HEIGHT1 = mDisplay.getHeight();
        CAMERA_WIDTH1 = mDisplay.getWidth();
        camera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
        EngineOptions engineOptions = new EngineOptions(true, ScreenOrientation.LANDSCAPE_FIXED, new FillResolutionPolicy(), camera);
        engineOptions.getAudioOptions().setNeedsMusic(true);
        return engineOptions;
    }
    @Override
    public void onCreateResources(OnCreateResourcesCallback pOnCreateResourcesCallback) throws IOException {
        // Log.d("-------onCreateResources()---------", " ");
       BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
        splashTextureAtlas = new AssetBitmapTexture(this.getTextureManager(), this.getAssets(), "gfx/splashImage.png");
        splashTextureRegion =  TextureRegionFactory.extractFromTexture(this.splashTextureAtlas);

        this.mPlayerTexture = new AssetBitmapTexture(this.getTextureManager(), this.getAssets(), "gfx/playerr.png", TextureOptions.BILINEAR);
        this.mPlayerTextureRegion = TextureRegionFactory.extractTiledFromTexture(this.mPlayerTexture, 1, 1);
        this.mPlayerTexture.load();

        this.mParallaxLayerBackTexture = new AssetBitmapTexture(this.getTextureManager(), this.getAssets(), "gfx/parallax_background_layer_back11.png");
        this.mParallaxLayerBackTextureRegion = TextureRegionFactory.extractFromTexture(this.mParallaxLayerBackTexture);
        this.mParallaxLayerBackTexture.load();

        this.mParallaxLayerMidTexture = new AssetBitmapTexture(this.getTextureManager(), this.getAssets(), "gfx/clouds.png");
        this.mParallaxLayerMidTextureRegion = TextureRegionFactory.extractFromTexture(this.mParallaxLayerMidTexture);
        this.mParallaxLayerMidTexture.load();


        this.mParallaxLayercloud = new AssetBitmapTexture(this.getTextureManager(), this.getAssets(), "gfx/road.png");
       this.mParallaxLayercloudTextureRegion = TextureRegionFactory.extractFromTexture(this.mParallaxLayercloud);
        this.mParallaxLayercloud.load();

        BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
        this.mBuildableBitmapTextureAtlas = new BuildableBitmapTextureAtlas(this.getTextureManager(), 312, 312);
        this.mButtonNormalTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mBuildableBitmapTextureAtlas, this, "play1.png");
        this.mPressedTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mBuildableBitmapTextureAtlas, this, "play2.png");
        this.mDisabledTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mBuildableBitmapTextureAtlas, this, "button_disabled.png");

        try {
            this.mBuildableBitmapTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(15, 14, 10));
            this.mBuildableBitmapTextureAtlas.load();
        } catch (ITextureAtlasBuilder.TextureAtlasBuilderException e) {
            Debug.e(e);
        }
        this.mHomeTexture = new AssetBitmapTexture(this.getTextureManager(), this.getAssets(), "gfx/home_button.png", TextureOptions.BILINEAR);
        this.mHomeTextrueRegin = TextureRegionFactory.extractFromTexture(this.mHomeTexture);
        this.mHomeTexture.load();

        this.mRestrartTextrue = new AssetBitmapTexture(this.getTextureManager(), this.getAssets(), "gfx/restart_game_button.png", TextureOptions.BILINEAR);
        this.mRestartTextureRegion = TextureRegionFactory.extractFromTexture(this.mRestrartTextrue);
        this.mRestrartTextrue.load();

        this.mNotesTexture = new AssetBitmapTexture(this.getTextureManager(), this.getAssets(), "gfx/sound1.png", TextureOptions.BILINEAR);
        this.mNotesTextureRegion = TextureRegionFactory.extractFromTexture(this.mNotesTexture);
        this.mNotesTexture.load();

        this.mfirstBoxTexure = new AssetBitmapTexture(this.getTextureManager(), this.getAssets(), "gfx/boxr64.png", TextureOptions.BILINEAR);
        this.mBoxFirstRegion = TextureRegionFactory.extractFromTexture(this.mfirstBoxTexure);
        this.mfirstBoxTexure.load();

        this.mBoxSecond = new AssetBitmapTexture(this.getTextureManager(), this.getAssets(), "gfx/boxr64.png", TextureOptions.BILINEAR);
        this.mBoxSecondRegion = TextureRegionFactory.extractFromTexture(this.mBoxSecond);
        this.mBoxSecond.load();

        this.mBoxThirdTexture = new AssetBitmapTexture(this.getTextureManager(), this.getAssets(), "gfx/boxr64.png", TextureOptions.BILINEAR);
        this.mBoxthirdRegion = TextureRegionFactory.extractFromTexture(this.mBoxThirdTexture);
        this.mBoxThirdTexture.load();

        this.mBoxForthTexture = new AssetBitmapTexture(this.getTextureManager(), this.getAssets(), "gfx/boxr64.png", TextureOptions.BILINEAR);
        this.mBoxForthReagion = TextureRegionFactory.extractFromTexture(this.mBoxForthTexture);
        this.mBoxForthTexture.load();

        this.mBoxFifthTexture = new AssetBitmapTexture(this.getTextureManager(), this.getAssets(), "gfx/boxr64.png", TextureOptions.BILINEAR);
        this.mBoxFifthRegion = TextureRegionFactory.extractFromTexture(this.mBoxFifthTexture);
        this.mBoxFifthTexture.load();

        this.mTopEendTexture = new AssetBitmapTexture(this.getTextureManager(), this.getAssets(), "gfx/topEend.png", TextureOptions.BILINEAR);
        this.mTopEendTextureRegion = TextureRegionFactory.extractFromTexture(this.mTopEendTexture);
        this.mTopEendTexture.load();
        this.mTopEendTexture2 = new AssetBitmapTexture(this.getTextureManager(), this.getAssets(), "gfx/topEend2.png", TextureOptions.BILINEAR);
        this.mTopEendTextureRegion2 = TextureRegionFactory.extractFromTexture(this.mTopEendTexture2);
        this.mTopEendTexture2.load();

        this.mTopEendTexture3 = new AssetBitmapTexture(this.getTextureManager(), this.getAssets(), "gfx/topEend2.png", TextureOptions.BILINEAR);
        this.mTopEendTextureRegion3 = TextureRegionFactory.extractTiledFromTexture(this.mTopEendTexture3, 3, 4);
        this.mTopEendTexture3.load();

        this.mquiTexture = new AssetBitmapTexture(this.getTextureManager(), this.getAssets(), "gfx/quit1.png", TextureOptions.BILINEAR);
        this.mquittextureRegion = TextureRegionFactory.extractFromTexture(this.mquiTexture);
        this.mquiTexture.load();
        MusicFactory.setAssetBasePath("mfx/");
        try {
           // this.mMusic = MusicFactory.createMusicFromAsset(this.mEngine.getMusicManager(), this, "wagner_the_ride_of_the_valkyries.ogg");
            this.mMusic = MusicFactory.createMusicFromAsset(this.mEngine.getMusicManager(), this, "my_music_game.mp3");
            this.mMusic.setLooping(true);
        } catch (final IOException e) {
            Debug.e(e);
        }
        this.mFont = FontFactory.create(this.getFontManager(), this.getTextureManager(), 1000, 1000, Typeface.create(Typeface.DEFAULT, Typeface.BOLD), 32);
        this.mFont.load();
        splashTextureAtlas.load();
        pOnCreateResourcesCallback.onCreateResourcesFinished();
    }
    @Override
    public void onCreateScene(OnCreateSceneCallback pOnCreateSceneCallback) throws IOException {
        initSplashScene();
        music();
        pOnCreateSceneCallback.onCreateSceneFinished(this.splashScene);
    }
    @Override
    public void onPopulateScene(Scene pScene, OnPopulateSceneCallback pOnPopulateSceneCallback) throws IOException {
        //  Log.d("-------onPopulateScene()---------", " ");
        mEngine.registerUpdateHandler(new TimerHandler(3f, new ITimerCallback() {
            public void onTimePassed(final TimerHandler pTimerHandler) {
                mEngine.unregisterUpdateHandler(pTimerHandler);
                loadResources();
                loadScenes();
                splash.detachSelf();
                mEngine.setScene(mainScene);
                currentScene = SceneType.MAIN;
            }
        }));

        pOnPopulateSceneCallback.onPopulateSceneFinished();
    }
    public void loadResources() {
    }

    private void loadScenes() {
        mainScene = new Scene();

        final float centerX = CAMERA_WIDTH / 2;
        final float centerY = CAMERA_HEIGHT / 2;
        final float centerX1 = CAMERA_WIDTH / 2;
        final float centerY1 = (float) (CAMERA_HEIGHT / 1.5);
        final float centerX2 = CAMERA_WIDTH / 2;
        //  final float centerY2 = CAMERA_HEIGHT / 3;
        final float centerY2 = (float) (CAMERA_HEIGHT / 2.9);
        final Sprite notes = new Sprite(centerX1, centerY1, this.mNotesTextureRegion, this.getVertexBufferObjectManager());
        mainScene.registerTouchArea(notes);
        mainScene.setOnAreaTouchListener(new IOnAreaTouchListener() {
            @Override
            public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final ITouchArea pTouchArea, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
                if (pSceneTouchEvent.isActionDown())
                    music();
                return true;
            }
        });
        final Sprite quitButton = new Sprite(centerX2, centerY2, this.mquittextureRegion, this.getVertexBufferObjectManager()){
                @Override
                public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
                    System.exit(0);
                    return true;
                }
    };
        mainScene.registerTouchArea(quitButton);
        mainScene.attachChild(quitButton);
        final ButtonSprite buttonSprite = new ButtonSprite(centerX, centerY,this.mButtonNormalTextureRegion, this.mPressedTextureRegion, this.mDisabledTextureRegion, this.getVertexBufferObjectManager(), this);
        mainScene.registerTouchArea(buttonSprite);
        mainScene.attachChild(notes);
        mainScene.attachChild(buttonSprite);
        mainScene.setTouchAreaBindingOnActionDownEnabled(true);
        mainScene.setBackground(new Background(Color.WHITE));
    }
    private Rectangle makeColoredRectangle(final float pX, final float pY, final Color pColor) {
        final Rectangle coloredRect = new Rectangle(pX, pY, RECTANGLE_SIZE, RECTANGLE_SIZE, this.getVertexBufferObjectManager());
        coloredRect.setColor(pColor);
        return coloredRect;
    }
    public void pauseGame() {
        mPauseScene = new CameraScene(camera);
     //   myscene.setBackground(new Background(Color.BLUE));
        mPauseScene.setBackgroundEnabled(false);
        mTopEndButton2 = new Sprite(48, 460, this.mTopEendTextureRegion2, this.getVertexBufferObjectManager());
        mTopEndButton2.setScale(1);
        mPauseScene.registerTouchArea(mTopEndButton2);
        mPauseScene.attachChild(mTopEndButton2);
       thirdScreen.setChildScene(mPauseScene, false, true, true);
        mEngine.stop();
    }

    public void unPauseGame() {
        thirdScreen.clearChildScene();
        mEngine.start();
    }
    void countScore(){

        count=count+1;
        mHudText.setText("Score:" + count);
    }
    void music() {
        try {
            if (GameActivity.this.mMusic.isPlaying()) {
                GameActivity.this.mMusic.pause();
            } else {
                GameActivity.this.mMusic.play();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void initSplashScene() throws IOException {
        //  Log.d("-------initSplashScene()---------", " ");
        splashScene = new Scene();
        splash = new Sprite(0, 0, splashTextureRegion, mEngine.getVertexBufferObjectManager()) {
            @Override
            protected void preDraw(GLState pGLState, Camera pCamera) {
                super.preDraw(pGLState, pCamera);
                pGLState.enableDither();
            }

        };
        splash.setScale(1.0f);
        splash.setPosition( CAMERA_WIDTH - splash.getWidth() * 0.5f , CAMERA_HEIGHT - splash.getHeight() * 0.5f);
        splashScene.attachChild(splash);
    }

//    @Override
//    public void onBackPressed() {
//       // super.onBackPressed();
//        System.exit(0);
//    }
}