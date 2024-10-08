package io.quarkus.arc;

/**
 * A configuration object used while initializing Arc, see {@link Arc#initialize()} methods.
 * Consolidates all configuration objects needed for Arc to initialize, values are initialized to their defaults.
 *
 */
public final class ArcInitConfig {

    /**
     * Basic instance without any configuration, all values are default
     */
    public static final ArcInitConfig DEFAULT = builder().build();

    /**
     * Obtains a builder for {@link ArcInitConfig}
     *
     * @return new instance of the builder
     */
    public static Builder builder() {
        return new Builder();
    }

    private ArcInitConfig(Builder builder) {
        this.currentContextFactory = builder.currentContextFactory;
        this.strictCompatibility = builder.strictCompatibility;
        this.optimizeContexts = builder.optimizeContexts;
    }

    private final boolean strictCompatibility;
    private final CurrentContextFactory currentContextFactory;
    private final boolean optimizeContexts;

    public boolean isStrictCompatibility() {
        return strictCompatibility;
    }

    public CurrentContextFactory getCurrentContextFactory() {
        return currentContextFactory;
    }

    public boolean isOptimizeContexts() {
        return optimizeContexts;
    }

    public static class Builder {
        private boolean strictCompatibility;
        private CurrentContextFactory currentContextFactory;
        private boolean optimizeContexts;

        private Builder() {
            // init all values with their defaults
            this.strictCompatibility = false;
            this.currentContextFactory = null;
            this.optimizeContexts = false;
        }

        public Builder setStrictCompatibility(boolean strictCompatibility) {
            this.strictCompatibility = strictCompatibility;
            return this;
        }

        public Builder setCurrentContextFactory(CurrentContextFactory currentContextFactory) {
            this.currentContextFactory = currentContextFactory;
            return this;
        }

        public Builder setOptimizeContexts(boolean value) {
            optimizeContexts = value;
            return this;
        }

        public ArcInitConfig build() {
            return new ArcInitConfig(this);
        }
    }
}
