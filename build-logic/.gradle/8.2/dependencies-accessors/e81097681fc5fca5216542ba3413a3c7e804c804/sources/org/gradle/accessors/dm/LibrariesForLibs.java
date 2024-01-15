package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.plugin.use.PluginDependency;
import org.gradle.api.artifacts.ExternalModuleDependencyBundle;
import org.gradle.api.artifacts.MutableVersionConstraint;
import org.gradle.api.provider.Provider;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory;
import org.gradle.api.internal.catalog.DefaultVersionCatalog;
import java.util.Map;
import org.gradle.api.internal.attributes.ImmutableAttributesFactory;
import org.gradle.api.internal.artifacts.dsl.CapabilityNotationParser;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the `libs` extension.
 */
@NonNullApi
public class LibrariesForLibs extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final AndroidLibraryAccessors laccForAndroidLibraryAccessors = new AndroidLibraryAccessors(owner);
    private final AndroidxLibraryAccessors laccForAndroidxLibraryAccessors = new AndroidxLibraryAccessors(owner);
    private final ArchLibraryAccessors laccForArchLibraryAccessors = new ArchLibraryAccessors(owner);
    private final BenchmarkLibraryAccessors laccForBenchmarkLibraryAccessors = new BenchmarkLibraryAccessors(owner);
    private final ChuckerLibraryAccessors laccForChuckerLibraryAccessors = new ChuckerLibraryAccessors(owner);
    private final CoroutinesLibraryAccessors laccForCoroutinesLibraryAccessors = new CoroutinesLibraryAccessors(owner);
    private final DetektLibraryAccessors laccForDetektLibraryAccessors = new DetektLibraryAccessors(owner);
    private final EspessoLibraryAccessors laccForEspessoLibraryAccessors = new EspessoLibraryAccessors(owner);
    private final HiltLibraryAccessors laccForHiltLibraryAccessors = new HiltLibraryAccessors(owner);
    private final JavapoetLibraryAccessors laccForJavapoetLibraryAccessors = new JavapoetLibraryAccessors(owner);
    private final JunitLibraryAccessors laccForJunitLibraryAccessors = new JunitLibraryAccessors(owner);
    private final KotlinLibraryAccessors laccForKotlinLibraryAccessors = new KotlinLibraryAccessors(owner);
    private final KotlinxLibraryAccessors laccForKotlinxLibraryAccessors = new KotlinxLibraryAccessors(owner);
    private final KspLibraryAccessors laccForKspLibraryAccessors = new KspLibraryAccessors(owner);
    private final LoggingLibraryAccessors laccForLoggingLibraryAccessors = new LoggingLibraryAccessors(owner);
    private final MockkAgentLibraryAccessors laccForMockkAgentLibraryAccessors = new MockkAgentLibraryAccessors(owner);
    private final MockkAndroidLibraryAccessors laccForMockkAndroidLibraryAccessors = new MockkAndroidLibraryAccessors(owner);
    private final NavigationLibraryAccessors laccForNavigationLibraryAccessors = new NavigationLibraryAccessors(owner);
    private final PagingLibraryAccessors laccForPagingLibraryAccessors = new PagingLibraryAccessors(owner);
    private final RoboelectricLibraryAccessors laccForRoboelectricLibraryAccessors = new RoboelectricLibraryAccessors(owner);
    private final RoomLibraryAccessors laccForRoomLibraryAccessors = new RoomLibraryAccessors(owner);
    private final TurbineLibraryAccessors laccForTurbineLibraryAccessors = new TurbineLibraryAccessors(owner);
    private final UiautomatorLibraryAccessors laccForUiautomatorLibraryAccessors = new UiautomatorLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForLibs(DefaultVersionCatalog config, ProviderFactory providers, ObjectFactory objects, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) {
        super(config, providers, objects, attributesFactory, capabilityNotationParser);
    }

        /**
         * Creates a dependency provider for glide (com.github.bumptech.glide:glide)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getGlide() {
            return create("glide");
    }

        /**
         * Creates a dependency provider for lottie (com.airbnb.android:lottie)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getLottie() {
            return create("lottie");
    }

        /**
         * Creates a dependency provider for material (com.google.android.material:material)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getMaterial() {
            return create("material");
    }

        /**
         * Creates a dependency provider for retrofit (com.squareup.retrofit2:retrofit)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getRetrofit() {
            return create("retrofit");
    }

        /**
         * Creates a dependency provider for timber (com.jakewharton.timber:timber)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getTimber() {
            return create("timber");
    }

    /**
     * Returns the group of libraries at android
     */
    public AndroidLibraryAccessors getAndroid() {
        return laccForAndroidLibraryAccessors;
    }

    /**
     * Returns the group of libraries at androidx
     */
    public AndroidxLibraryAccessors getAndroidx() {
        return laccForAndroidxLibraryAccessors;
    }

    /**
     * Returns the group of libraries at arch
     */
    public ArchLibraryAccessors getArch() {
        return laccForArchLibraryAccessors;
    }

    /**
     * Returns the group of libraries at benchmark
     */
    public BenchmarkLibraryAccessors getBenchmark() {
        return laccForBenchmarkLibraryAccessors;
    }

    /**
     * Returns the group of libraries at chucker
     */
    public ChuckerLibraryAccessors getChucker() {
        return laccForChuckerLibraryAccessors;
    }

    /**
     * Returns the group of libraries at coroutines
     */
    public CoroutinesLibraryAccessors getCoroutines() {
        return laccForCoroutinesLibraryAccessors;
    }

    /**
     * Returns the group of libraries at detekt
     */
    public DetektLibraryAccessors getDetekt() {
        return laccForDetektLibraryAccessors;
    }

    /**
     * Returns the group of libraries at espesso
     */
    public EspessoLibraryAccessors getEspesso() {
        return laccForEspessoLibraryAccessors;
    }

    /**
     * Returns the group of libraries at hilt
     */
    public HiltLibraryAccessors getHilt() {
        return laccForHiltLibraryAccessors;
    }

    /**
     * Returns the group of libraries at javapoet
     */
    public JavapoetLibraryAccessors getJavapoet() {
        return laccForJavapoetLibraryAccessors;
    }

    /**
     * Returns the group of libraries at junit
     */
    public JunitLibraryAccessors getJunit() {
        return laccForJunitLibraryAccessors;
    }

    /**
     * Returns the group of libraries at kotlin
     */
    public KotlinLibraryAccessors getKotlin() {
        return laccForKotlinLibraryAccessors;
    }

    /**
     * Returns the group of libraries at kotlinx
     */
    public KotlinxLibraryAccessors getKotlinx() {
        return laccForKotlinxLibraryAccessors;
    }

    /**
     * Returns the group of libraries at ksp
     */
    public KspLibraryAccessors getKsp() {
        return laccForKspLibraryAccessors;
    }

    /**
     * Returns the group of libraries at logging
     */
    public LoggingLibraryAccessors getLogging() {
        return laccForLoggingLibraryAccessors;
    }

    /**
     * Returns the group of libraries at mockkAgent
     */
    public MockkAgentLibraryAccessors getMockkAgent() {
        return laccForMockkAgentLibraryAccessors;
    }

    /**
     * Returns the group of libraries at mockkAndroid
     */
    public MockkAndroidLibraryAccessors getMockkAndroid() {
        return laccForMockkAndroidLibraryAccessors;
    }

    /**
     * Returns the group of libraries at navigation
     */
    public NavigationLibraryAccessors getNavigation() {
        return laccForNavigationLibraryAccessors;
    }

    /**
     * Returns the group of libraries at paging
     */
    public PagingLibraryAccessors getPaging() {
        return laccForPagingLibraryAccessors;
    }

    /**
     * Returns the group of libraries at roboelectric
     */
    public RoboelectricLibraryAccessors getRoboelectric() {
        return laccForRoboelectricLibraryAccessors;
    }

    /**
     * Returns the group of libraries at room
     */
    public RoomLibraryAccessors getRoom() {
        return laccForRoomLibraryAccessors;
    }

    /**
     * Returns the group of libraries at turbine
     */
    public TurbineLibraryAccessors getTurbine() {
        return laccForTurbineLibraryAccessors;
    }

    /**
     * Returns the group of libraries at uiautomator
     */
    public UiautomatorLibraryAccessors getUiautomator() {
        return laccForUiautomatorLibraryAccessors;
    }

    /**
     * Returns the group of versions at versions
     */
    public VersionAccessors getVersions() {
        return vaccForVersionAccessors;
    }

    /**
     * Returns the group of bundles at bundles
     */
    public BundleAccessors getBundles() {
        return baccForBundleAccessors;
    }

    /**
     * Returns the group of plugins at plugins
     */
    public PluginAccessors getPlugins() {
        return paccForPluginAccessors;
    }

    public static class AndroidLibraryAccessors extends SubDependencyFactory {
        private final AndroidGradleLibraryAccessors laccForAndroidGradleLibraryAccessors = new AndroidGradleLibraryAccessors(owner);

        public AndroidLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at android.gradle
         */
        public AndroidGradleLibraryAccessors getGradle() {
            return laccForAndroidGradleLibraryAccessors;
        }

    }

    public static class AndroidGradleLibraryAccessors extends SubDependencyFactory {

        public AndroidGradleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for plugin (com.android.tools.build:gradle)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getPlugin() {
                return create("android.gradle.plugin");
        }

    }

    public static class AndroidxLibraryAccessors extends SubDependencyFactory {
        private final AndroidxCoreLibraryAccessors laccForAndroidxCoreLibraryAccessors = new AndroidxCoreLibraryAccessors(owner);
        private final AndroidxFragmentLibraryAccessors laccForAndroidxFragmentLibraryAccessors = new AndroidxFragmentLibraryAccessors(owner);
        private final AndroidxLifecycleLibraryAccessors laccForAndroidxLifecycleLibraryAccessors = new AndroidxLifecycleLibraryAccessors(owner);
        private final AndroidxNavigationLibraryAccessors laccForAndroidxNavigationLibraryAccessors = new AndroidxNavigationLibraryAccessors(owner);
        private final AndroidxRoomLibraryAccessors laccForAndroidxRoomLibraryAccessors = new AndroidxRoomLibraryAccessors(owner);
        private final AndroidxSplashLibraryAccessors laccForAndroidxSplashLibraryAccessors = new AndroidxSplashLibraryAccessors(owner);
        private final AndroidxViewmodelLibraryAccessors laccForAndroidxViewmodelLibraryAccessors = new AndroidxViewmodelLibraryAccessors(owner);

        public AndroidxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for appcompat (androidx.appcompat:appcompat)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getAppcompat() {
                return create("androidx.appcompat");
        }

            /**
             * Creates a dependency provider for cardview (androidx.cardview:cardview)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCardview() {
                return create("androidx.cardview");
        }

            /**
             * Creates a dependency provider for constraintlayout (androidx.constraintlayout:constraintlayout)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getConstraintlayout() {
                return create("androidx.constraintlayout");
        }

            /**
             * Creates a dependency provider for paging (androidx.paging:paging-runtime)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getPaging() {
                return create("androidx.paging");
        }

            /**
             * Creates a dependency provider for profileinstaller (androidx.profileinstaller:profileinstaller)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getProfileinstaller() {
                return create("androidx.profileinstaller");
        }

            /**
             * Creates a dependency provider for recyclerview (androidx.recyclerview:recyclerview)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getRecyclerview() {
                return create("androidx.recyclerview");
        }

            /**
             * Creates a dependency provider for swiperefreshlayout (androidx.swiperefreshlayout:swiperefreshlayout)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getSwiperefreshlayout() {
                return create("androidx.swiperefreshlayout");
        }

        /**
         * Returns the group of libraries at androidx.core
         */
        public AndroidxCoreLibraryAccessors getCore() {
            return laccForAndroidxCoreLibraryAccessors;
        }

        /**
         * Returns the group of libraries at androidx.fragment
         */
        public AndroidxFragmentLibraryAccessors getFragment() {
            return laccForAndroidxFragmentLibraryAccessors;
        }

        /**
         * Returns the group of libraries at androidx.lifecycle
         */
        public AndroidxLifecycleLibraryAccessors getLifecycle() {
            return laccForAndroidxLifecycleLibraryAccessors;
        }

        /**
         * Returns the group of libraries at androidx.navigation
         */
        public AndroidxNavigationLibraryAccessors getNavigation() {
            return laccForAndroidxNavigationLibraryAccessors;
        }

        /**
         * Returns the group of libraries at androidx.room
         */
        public AndroidxRoomLibraryAccessors getRoom() {
            return laccForAndroidxRoomLibraryAccessors;
        }

        /**
         * Returns the group of libraries at androidx.splash
         */
        public AndroidxSplashLibraryAccessors getSplash() {
            return laccForAndroidxSplashLibraryAccessors;
        }

        /**
         * Returns the group of libraries at androidx.viewmodel
         */
        public AndroidxViewmodelLibraryAccessors getViewmodel() {
            return laccForAndroidxViewmodelLibraryAccessors;
        }

    }

    public static class AndroidxCoreLibraryAccessors extends SubDependencyFactory {

        public AndroidxCoreLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for ktx (androidx.core:core-ktx)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getKtx() {
                return create("androidx.core.ktx");
        }

    }

    public static class AndroidxFragmentLibraryAccessors extends SubDependencyFactory {

        public AndroidxFragmentLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for ktx (androidx.fragment:fragment-ktx)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getKtx() {
                return create("androidx.fragment.ktx");
        }

    }

    public static class AndroidxLifecycleLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {
        private final AndroidxLifecycleViewmodelLibraryAccessors laccForAndroidxLifecycleViewmodelLibraryAccessors = new AndroidxLifecycleViewmodelLibraryAccessors(owner);

        public AndroidxLifecycleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for lifecycle (androidx.lifecycle:lifecycle-runtime-ktx)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() {
                return create("androidx.lifecycle");
        }

        /**
         * Returns the group of libraries at androidx.lifecycle.viewmodel
         */
        public AndroidxLifecycleViewmodelLibraryAccessors getViewmodel() {
            return laccForAndroidxLifecycleViewmodelLibraryAccessors;
        }

    }

    public static class AndroidxLifecycleViewmodelLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {
        private final AndroidxLifecycleViewmodelSavedLibraryAccessors laccForAndroidxLifecycleViewmodelSavedLibraryAccessors = new AndroidxLifecycleViewmodelSavedLibraryAccessors(owner);

        public AndroidxLifecycleViewmodelLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for viewmodel (androidx.lifecycle:lifecycle-viewmodel-ktx)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() {
                return create("androidx.lifecycle.viewmodel");
        }

        /**
         * Returns the group of libraries at androidx.lifecycle.viewmodel.saved
         */
        public AndroidxLifecycleViewmodelSavedLibraryAccessors getSaved() {
            return laccForAndroidxLifecycleViewmodelSavedLibraryAccessors;
        }

    }

    public static class AndroidxLifecycleViewmodelSavedLibraryAccessors extends SubDependencyFactory {

        public AndroidxLifecycleViewmodelSavedLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for state (androidx.lifecycle:lifecycle-viewmodel-savedstate)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getState() {
                return create("androidx.lifecycle.viewmodel.saved.state");
        }

    }

    public static class AndroidxNavigationLibraryAccessors extends SubDependencyFactory {

        public AndroidxNavigationLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for fragment (androidx.navigation:navigation-fragment-ktx)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getFragment() {
                return create("androidx.navigation.fragment");
        }

            /**
             * Creates a dependency provider for ui (androidx.navigation:navigation-ui-ktx)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getUi() {
                return create("androidx.navigation.ui");
        }

    }

    public static class AndroidxRoomLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public AndroidxRoomLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for room (androidx.room:room-runtime)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() {
                return create("androidx.room");
        }

            /**
             * Creates a dependency provider for ktx (androidx.room:room-ktx)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getKtx() {
                return create("androidx.room.ktx");
        }

            /**
             * Creates a dependency provider for paging (androidx.room:room-paging)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getPaging() {
                return create("androidx.room.paging");
        }

    }

    public static class AndroidxSplashLibraryAccessors extends SubDependencyFactory {

        public AndroidxSplashLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for screen (androidx.core:core-splashscreen)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getScreen() {
                return create("androidx.splash.screen");
        }

    }

    public static class AndroidxViewmodelLibraryAccessors extends SubDependencyFactory {

        public AndroidxViewmodelLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for ktx (androidx.lifecycle:lifecycle-viewmodel-ktx)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getKtx() {
                return create("androidx.viewmodel.ktx");
        }

    }

    public static class ArchLibraryAccessors extends SubDependencyFactory {
        private final ArchCoreLibraryAccessors laccForArchCoreLibraryAccessors = new ArchCoreLibraryAccessors(owner);

        public ArchLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at arch.core
         */
        public ArchCoreLibraryAccessors getCore() {
            return laccForArchCoreLibraryAccessors;
        }

    }

    public static class ArchCoreLibraryAccessors extends SubDependencyFactory {

        public ArchCoreLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for test (androidx.arch.core:core-testing)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getTest() {
                return create("arch.core.test");
        }

    }

    public static class BenchmarkLibraryAccessors extends SubDependencyFactory {
        private final BenchmarkMacroLibraryAccessors laccForBenchmarkMacroLibraryAccessors = new BenchmarkMacroLibraryAccessors(owner);

        public BenchmarkLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at benchmark.macro
         */
        public BenchmarkMacroLibraryAccessors getMacro() {
            return laccForBenchmarkMacroLibraryAccessors;
        }

    }

    public static class BenchmarkMacroLibraryAccessors extends SubDependencyFactory {

        public BenchmarkMacroLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for androidTest (androidx.benchmark:benchmark-macro-junit4)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getAndroidTest() {
                return create("benchmark.macro.androidTest");
        }

    }

    public static class ChuckerLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {
        private final ChuckerNoLibraryAccessors laccForChuckerNoLibraryAccessors = new ChuckerNoLibraryAccessors(owner);

        public ChuckerLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for chucker (com.github.chuckerteam.chucker:library)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() {
                return create("chucker");
        }

        /**
         * Returns the group of libraries at chucker.no
         */
        public ChuckerNoLibraryAccessors getNo() {
            return laccForChuckerNoLibraryAccessors;
        }

    }

    public static class ChuckerNoLibraryAccessors extends SubDependencyFactory {

        public ChuckerNoLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for op (com.github.chuckerteam.chucker:library-no-op)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getOp() {
                return create("chucker.no.op");
        }

    }

    public static class CoroutinesLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public CoroutinesLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for coroutines (org.jetbrains.kotlinx:kotlinx-coroutines-android)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() {
                return create("coroutines");
        }

            /**
             * Creates a dependency provider for test (org.jetbrains.kotlinx:kotlinx-coroutines-test)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getTest() {
                return create("coroutines.test");
        }

    }

    public static class DetektLibraryAccessors extends SubDependencyFactory {

        public DetektLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for formating (io.gitlab.arturbosch.detekt:detekt-formatting)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getFormating() {
                return create("detekt.formating");
        }

            /**
             * Creates a dependency provider for plugin (io.gitlab.arturbosch.detekt:detekt-gradle-plugin)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getPlugin() {
                return create("detekt.plugin");
        }

            /**
             * Creates a dependency provider for rules (io.gitlab.arturbosch.detekt:detekt-rules)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getRules() {
                return create("detekt.rules");
        }

    }

    public static class EspessoLibraryAccessors extends SubDependencyFactory {

        public EspessoLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for androidTest (androidx.test.espresso:espresso-core)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getAndroidTest() {
                return create("espesso.androidTest");
        }

    }

    public static class HiltLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public HiltLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for hilt (com.google.dagger:hilt-android)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() {
                return create("hilt");
        }

            /**
             * Creates a dependency provider for androidTest (com.google.dagger:hilt-android-testing)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getAndroidTest() {
                return create("hilt.androidTest");
        }

            /**
             * Creates a dependency provider for compiler (com.google.dagger:hilt-compiler)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCompiler() {
                return create("hilt.compiler");
        }

            /**
             * Creates a dependency provider for test (com.google.dagger:hilt-android-testing)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getTest() {
                return create("hilt.test");
        }

    }

    public static class JavapoetLibraryAccessors extends SubDependencyFactory {

        public JavapoetLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for plugin (com.squareup:javapoet)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getPlugin() {
                return create("javapoet.plugin");
        }

    }

    public static class JunitLibraryAccessors extends SubDependencyFactory {

        public JunitLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for androidTest (androidx.test.ext:junit)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getAndroidTest() {
                return create("junit.androidTest");
        }

            /**
             * Creates a dependency provider for test (junit:junit)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getTest() {
                return create("junit.test");
        }

    }

    public static class KotlinLibraryAccessors extends SubDependencyFactory {

        public KotlinLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for plugin (org.jetbrains.kotlin:kotlin-gradle-plugin)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getPlugin() {
                return create("kotlin.plugin");
        }

    }

    public static class KotlinxLibraryAccessors extends SubDependencyFactory {
        private final KotlinxKoverLibraryAccessors laccForKotlinxKoverLibraryAccessors = new KotlinxKoverLibraryAccessors(owner);
        private final KotlinxSerializationLibraryAccessors laccForKotlinxSerializationLibraryAccessors = new KotlinxSerializationLibraryAccessors(owner);

        public KotlinxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at kotlinx.kover
         */
        public KotlinxKoverLibraryAccessors getKover() {
            return laccForKotlinxKoverLibraryAccessors;
        }

        /**
         * Returns the group of libraries at kotlinx.serialization
         */
        public KotlinxSerializationLibraryAccessors getSerialization() {
            return laccForKotlinxSerializationLibraryAccessors;
        }

    }

    public static class KotlinxKoverLibraryAccessors extends SubDependencyFactory {

        public KotlinxKoverLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for plugin (org.jetbrains.kotlinx:kover-gradle-plugin)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getPlugin() {
                return create("kotlinx.kover.plugin");
        }

    }

    public static class KotlinxSerializationLibraryAccessors extends SubDependencyFactory {

        public KotlinxSerializationLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for converter (com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getConverter() {
                return create("kotlinx.serialization.converter");
        }

            /**
             * Creates a dependency provider for json (org.jetbrains.kotlinx:kotlinx-serialization-json)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getJson() {
                return create("kotlinx.serialization.json");
        }

    }

    public static class KspLibraryAccessors extends SubDependencyFactory {
        private final KspGradleLibraryAccessors laccForKspGradleLibraryAccessors = new KspGradleLibraryAccessors(owner);

        public KspLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at ksp.gradle
         */
        public KspGradleLibraryAccessors getGradle() {
            return laccForKspGradleLibraryAccessors;
        }

    }

    public static class KspGradleLibraryAccessors extends SubDependencyFactory {

        public KspGradleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for plugin (com.google.devtools.ksp:com.google.devtools.ksp.gradle.plugin)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getPlugin() {
                return create("ksp.gradle.plugin");
        }

    }

    public static class LoggingLibraryAccessors extends SubDependencyFactory {

        public LoggingLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for interceptor (com.squareup.okhttp3:logging-interceptor)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getInterceptor() {
                return create("logging.interceptor");
        }

    }

    public static class MockkAgentLibraryAccessors extends SubDependencyFactory {

        public MockkAgentLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for test (io.mockk:mockk-agent)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getTest() {
                return create("mockkAgent.test");
        }

    }

    public static class MockkAndroidLibraryAccessors extends SubDependencyFactory {

        public MockkAndroidLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for test (io.mockk:mockk-android)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getTest() {
                return create("mockkAndroid.test");
        }

    }

    public static class NavigationLibraryAccessors extends SubDependencyFactory {
        private final NavigationSafeargsLibraryAccessors laccForNavigationSafeargsLibraryAccessors = new NavigationSafeargsLibraryAccessors(owner);

        public NavigationLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at navigation.safeargs
         */
        public NavigationSafeargsLibraryAccessors getSafeargs() {
            return laccForNavigationSafeargsLibraryAccessors;
        }

    }

    public static class NavigationSafeargsLibraryAccessors extends SubDependencyFactory {

        public NavigationSafeargsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for plugin (androidx.navigation:navigation-safe-args-gradle-plugin)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getPlugin() {
                return create("navigation.safeargs.plugin");
        }

    }

    public static class PagingLibraryAccessors extends SubDependencyFactory {
        private final PagingCommonLibraryAccessors laccForPagingCommonLibraryAccessors = new PagingCommonLibraryAccessors(owner);

        public PagingLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for test (androidx.paging:paging-testing)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getTest() {
                return create("paging.test");
        }

        /**
         * Returns the group of libraries at paging.common
         */
        public PagingCommonLibraryAccessors getCommon() {
            return laccForPagingCommonLibraryAccessors;
        }

    }

    public static class PagingCommonLibraryAccessors extends SubDependencyFactory {

        public PagingCommonLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for test (androidx.paging:paging-common)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getTest() {
                return create("paging.common.test");
        }

    }

    public static class RoboelectricLibraryAccessors extends SubDependencyFactory {

        public RoboelectricLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for test (org.robolectric:robolectric)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getTest() {
                return create("roboelectric.test");
        }

    }

    public static class RoomLibraryAccessors extends SubDependencyFactory {

        public RoomLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for compiler (androidx.room:room-compiler)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCompiler() {
                return create("room.compiler");
        }

            /**
             * Creates a dependency provider for test (androidx.room:room-testing)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getTest() {
                return create("room.test");
        }

    }

    public static class TurbineLibraryAccessors extends SubDependencyFactory {

        public TurbineLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for test (app.cash.turbine:turbine)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getTest() {
                return create("turbine.test");
        }

    }

    public static class UiautomatorLibraryAccessors extends SubDependencyFactory {

        public UiautomatorLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for androidTest (androidx.test.uiautomator:uiautomator)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getAndroidTest() {
                return create("uiautomator.androidTest");
        }

    }

    public static class VersionAccessors extends VersionFactory  {

        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: androidGradlePlugin (8.1.3)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getAndroidGradlePlugin() { return getVersion("androidGradlePlugin"); }

            /**
             * Returns the version associated to this alias: appCompat (1.6.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getAppCompat() { return getVersion("appCompat"); }

            /**
             * Returns the version associated to this alias: archCore (2.2.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getArchCore() { return getVersion("archCore"); }

            /**
             * Returns the version associated to this alias: benchmarkMacro (1.2.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getBenchmarkMacro() { return getVersion("benchmarkMacro"); }

            /**
             * Returns the version associated to this alias: cardview (1.0.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getCardview() { return getVersion("cardview"); }

            /**
             * Returns the version associated to this alias: chucker (4.0.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getChucker() { return getVersion("chucker"); }

            /**
             * Returns the version associated to this alias: constraintlayout (2.1.4)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getConstraintlayout() { return getVersion("constraintlayout"); }

            /**
             * Returns the version associated to this alias: coreKtx (1.12.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getCoreKtx() { return getVersion("coreKtx"); }

            /**
             * Returns the version associated to this alias: coroutines (1.7.3)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getCoroutines() { return getVersion("coroutines"); }

            /**
             * Returns the version associated to this alias: detekt (1.23.3)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getDetekt() { return getVersion("detekt"); }

            /**
             * Returns the version associated to this alias: espresso (3.5.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getEspresso() { return getVersion("espresso"); }

            /**
             * Returns the version associated to this alias: fragmentKtx (1.6.2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getFragmentKtx() { return getVersion("fragmentKtx"); }

            /**
             * Returns the version associated to this alias: glide (4.16.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getGlide() { return getVersion("glide"); }

            /**
             * Returns the version associated to this alias: hilt (2.48.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getHilt() { return getVersion("hilt"); }

            /**
             * Returns the version associated to this alias: hiltPlugin (2.48.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getHiltPlugin() { return getVersion("hiltPlugin"); }

            /**
             * Returns the version associated to this alias: jacocoAggregateCoverage (0.1.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getJacocoAggregateCoverage() { return getVersion("jacocoAggregateCoverage"); }

            /**
             * Returns the version associated to this alias: jacocoPlugin (0.8.9)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getJacocoPlugin() { return getVersion("jacocoPlugin"); }

            /**
             * Returns the version associated to this alias: javapoet (1.13.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getJavapoet() { return getVersion("javapoet"); }

            /**
             * Returns the version associated to this alias: junit (4.13.2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getJunit() { return getVersion("junit"); }

            /**
             * Returns the version associated to this alias: junitAndroid (1.1.5)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getJunitAndroid() { return getVersion("junitAndroid"); }

            /**
             * Returns the version associated to this alias: kotlin (1.9.20)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getKotlin() { return getVersion("kotlin"); }

            /**
             * Returns the version associated to this alias: kotlinxSerializationConverterVersion (1.0.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getKotlinxSerializationConverterVersion() { return getVersion("kotlinxSerializationConverterVersion"); }

            /**
             * Returns the version associated to this alias: kotlinxSerializationJson (1.6.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getKotlinxSerializationJson() { return getVersion("kotlinxSerializationJson"); }

            /**
             * Returns the version associated to this alias: kover (0.7.4)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getKover() { return getVersion("kover"); }

            /**
             * Returns the version associated to this alias: kspGradlePlugin (1.9.20-1.0.14)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getKspGradlePlugin() { return getVersion("kspGradlePlugin"); }

            /**
             * Returns the version associated to this alias: ktlintPlugin (11.6.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getKtlintPlugin() { return getVersion("ktlintPlugin"); }

            /**
             * Returns the version associated to this alias: lifecycle (2.6.2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getLifecycle() { return getVersion("lifecycle"); }

            /**
             * Returns the version associated to this alias: loggingInterceptor (4.12.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getLoggingInterceptor() { return getVersion("loggingInterceptor"); }

            /**
             * Returns the version associated to this alias: lottie (6.1.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getLottie() { return getVersion("lottie"); }

            /**
             * Returns the version associated to this alias: material (1.10.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getMaterial() { return getVersion("material"); }

            /**
             * Returns the version associated to this alias: mockk (1.13.8)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getMockk() { return getVersion("mockk"); }

            /**
             * Returns the version associated to this alias: moduleGraphAssertion (2.5.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getModuleGraphAssertion() { return getVersion("moduleGraphAssertion"); }

            /**
             * Returns the version associated to this alias: navigation (2.7.5)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getNavigation() { return getVersion("navigation"); }

            /**
             * Returns the version associated to this alias: navigationSafeargs (2.7.5)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getNavigationSafeargs() { return getVersion("navigationSafeargs"); }

            /**
             * Returns the version associated to this alias: paging (3.2.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getPaging() { return getVersion("paging"); }

            /**
             * Returns the version associated to this alias: profileInstaller (1.3.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getProfileInstaller() { return getVersion("profileInstaller"); }

            /**
             * Returns the version associated to this alias: recyclerview (1.3.2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getRecyclerview() { return getVersion("recyclerview"); }

            /**
             * Returns the version associated to this alias: retrofit (2.9.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getRetrofit() { return getVersion("retrofit"); }

            /**
             * Returns the version associated to this alias: roboelectric (4.11.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getRoboelectric() { return getVersion("roboelectric"); }

            /**
             * Returns the version associated to this alias: room (2.6.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getRoom() { return getVersion("room"); }

            /**
             * Returns the version associated to this alias: splashScreen (1.0.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getSplashScreen() { return getVersion("splashScreen"); }

            /**
             * Returns the version associated to this alias: swiperefreshlayout (1.1.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getSwiperefreshlayout() { return getVersion("swiperefreshlayout"); }

            /**
             * Returns the version associated to this alias: timber (5.0.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getTimber() { return getVersion("timber"); }

            /**
             * Returns the version associated to this alias: turbine (1.0.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getTurbine() { return getVersion("turbine"); }

            /**
             * Returns the version associated to this alias: uiautomator (2.2.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getUiautomator() { return getVersion("uiautomator"); }

            /**
             * Returns the version associated to this alias: versionsPlugin (0.49.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getVersionsPlugin() { return getVersion("versionsPlugin"); }

            /**
             * Returns the version associated to this alias: viewModelKtx (2.6.2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getViewModelKtx() { return getVersion("viewModelKtx"); }

    }

    public static class BundleAccessors extends BundleFactory {
        private final AndroidxBundleAccessors baccForAndroidxBundleAccessors = new AndroidxBundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);

        public BundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

            /**
             * Creates a dependency bundle provider for detekt which is an aggregate for the following dependencies:
             * <ul>
             *    <li>io.gitlab.arturbosch.detekt:detekt-formatting</li>
             *    <li>io.gitlab.arturbosch.detekt:detekt-rules</li>
             * </ul>
             * This bundle was declared in catalog libs.versions.toml
             */
            public Provider<ExternalModuleDependencyBundle> getDetekt() {
                return createBundle("detekt");
            }

        /**
         * Returns the group of bundles at bundles.androidx
         */
        public AndroidxBundleAccessors getAndroidx() {
            return baccForAndroidxBundleAccessors;
        }

    }

    public static class AndroidxBundleAccessors extends BundleFactory {

        public AndroidxBundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

            /**
             * Creates a dependency bundle provider for androidx.lifecycle which is an aggregate for the following dependencies:
             * <ul>
             *    <li>androidx.lifecycle:lifecycle-runtime-ktx</li>
             *    <li>androidx.lifecycle:lifecycle-viewmodel-ktx</li>
             *    <li>androidx.lifecycle:lifecycle-viewmodel-savedstate</li>
             * </ul>
             * This bundle was declared in catalog libs.versions.toml
             */
            public Provider<ExternalModuleDependencyBundle> getLifecycle() {
                return createBundle("androidx.lifecycle");
            }

            /**
             * Creates a dependency bundle provider for androidx.navigation which is an aggregate for the following dependencies:
             * <ul>
             *    <li>androidx.navigation:navigation-fragment-ktx</li>
             *    <li>androidx.navigation:navigation-ui-ktx</li>
             * </ul>
             * This bundle was declared in catalog libs.versions.toml
             */
            public Provider<ExternalModuleDependencyBundle> getNavigation() {
                return createBundle("androidx.navigation");
            }

            /**
             * Creates a dependency bundle provider for androidx.room which is an aggregate for the following dependencies:
             * <ul>
             *    <li>androidx.room:room-runtime</li>
             *    <li>androidx.room:room-ktx</li>
             *    <li>androidx.room:room-paging</li>
             * </ul>
             * This bundle was declared in catalog libs.versions.toml
             */
            public Provider<ExternalModuleDependencyBundle> getRoom() {
                return createBundle("androidx.room");
            }

    }

    public static class PluginAccessors extends PluginFactory {
        private final JacocoPluginAccessors paccForJacocoPluginAccessors = new JacocoPluginAccessors(providers, config);
        private final KotlinPluginAccessors paccForKotlinPluginAccessors = new KotlinPluginAccessors(providers, config);
        private final KotlinxPluginAccessors paccForKotlinxPluginAccessors = new KotlinxPluginAccessors(providers, config);
        private final ModulePluginAccessors paccForModulePluginAccessors = new ModulePluginAccessors(providers, config);

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for hilt to the plugin id 'dagger.hilt.android.plugin'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getHilt() { return createPlugin("hilt"); }

            /**
             * Creates a plugin provider for ksp to the plugin id 'com.google.devtools.ksp'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getKsp() { return createPlugin("ksp"); }

            /**
             * Creates a plugin provider for ktlint to the plugin id 'org.jlleitschuh.gradle.ktlint'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getKtlint() { return createPlugin("ktlint"); }

            /**
             * Creates a plugin provider for versions to the plugin id 'com.github.ben-manes.versions'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getVersions() { return createPlugin("versions"); }

        /**
         * Returns the group of plugins at plugins.jacoco
         */
        public JacocoPluginAccessors getJacoco() {
            return paccForJacocoPluginAccessors;
        }

        /**
         * Returns the group of plugins at plugins.kotlin
         */
        public KotlinPluginAccessors getKotlin() {
            return paccForKotlinPluginAccessors;
        }

        /**
         * Returns the group of plugins at plugins.kotlinx
         */
        public KotlinxPluginAccessors getKotlinx() {
            return paccForKotlinxPluginAccessors;
        }

        /**
         * Returns the group of plugins at plugins.module
         */
        public ModulePluginAccessors getModule() {
            return paccForModulePluginAccessors;
        }

    }

    public static class JacocoPluginAccessors extends PluginFactory {
        private final JacocoAggregatePluginAccessors paccForJacocoAggregatePluginAccessors = new JacocoAggregatePluginAccessors(providers, config);

        public JacocoPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of plugins at plugins.jacoco.aggregate
         */
        public JacocoAggregatePluginAccessors getAggregate() {
            return paccForJacocoAggregatePluginAccessors;
        }

    }

    public static class JacocoAggregatePluginAccessors extends PluginFactory {

        public JacocoAggregatePluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for jacoco.aggregate.coverage to the plugin id 'com.azizutku.jacocoaggregatecoverageplugin'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getCoverage() { return createPlugin("jacoco.aggregate.coverage"); }

    }

    public static class KotlinPluginAccessors extends PluginFactory {

        public KotlinPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for kotlin.jvm to the plugin id 'org.jetbrains.kotlin.jvm'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getJvm() { return createPlugin("kotlin.jvm"); }

            /**
             * Creates a plugin provider for kotlin.serialization to the plugin id 'org.jetbrains.kotlin.plugin.serialization'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getSerialization() { return createPlugin("kotlin.serialization"); }

    }

    public static class KotlinxPluginAccessors extends PluginFactory {

        public KotlinxPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for kotlinx.kover to the plugin id 'org.jetbrains.kotlinx.kover'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getKover() { return createPlugin("kotlinx.kover"); }

    }

    public static class ModulePluginAccessors extends PluginFactory {
        private final ModuleGraphPluginAccessors paccForModuleGraphPluginAccessors = new ModuleGraphPluginAccessors(providers, config);

        public ModulePluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of plugins at plugins.module.graph
         */
        public ModuleGraphPluginAccessors getGraph() {
            return paccForModuleGraphPluginAccessors;
        }

    }

    public static class ModuleGraphPluginAccessors extends PluginFactory {

        public ModuleGraphPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for module.graph.assertion to the plugin id 'com.jraska.module.graph.assertion'
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getAssertion() { return createPlugin("module.graph.assertion"); }

    }

}
