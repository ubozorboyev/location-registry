package com.example.astalos.locationregistry.domain.repository

/**
 * @author Tomasz Czura on 9/4/18.
 */
sealed class Failure {
    class UnknownFailure : Failure()

    abstract class DetailedFailure: Failure()
}