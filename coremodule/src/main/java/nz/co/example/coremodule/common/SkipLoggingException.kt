package nz.co.example.coremodule.common

/**
 * Marker interface for exception that are expected to happen, e.g. based on bad user input,
 * and shouldn't be logged / reporting as anything requiring developer intervention.
 */
interface SkipLoggingException