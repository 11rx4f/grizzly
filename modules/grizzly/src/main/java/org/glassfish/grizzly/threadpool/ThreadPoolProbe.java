/*
 * Copyright (c) 2010, 2020 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

package org.glassfish.grizzly.threadpool;

/**
 * Monitoring probe providing callbacks that may be invoked by Grizzly {@link AbstractThreadPool} implementations.
 *
 * @author gustav trede
 * @author Alexey Stashok
 *
 * @since 1.9.19
 */
public interface ThreadPoolProbe {
    /**
     * <p>
     * This event may be fired when an {@link AbstractThreadPool} implementation starts running.
     * </p>
     *
     * @param threadPool the {@link AbstractThreadPool} being monitored
     */
    void onThreadPoolStartEvent(AbstractThreadPool threadPool);

    /**
     * <p>
     * This event may be fired when an {@link AbstractThreadPool} implementation stops.
     * </p>
     *
     * @param threadPool the {@link AbstractThreadPool} being monitored
     */
    void onThreadPoolStopEvent(AbstractThreadPool threadPool);

    /**
     * <p>
     * This event may be fired when an {@link AbstractThreadPool} implementation allocates a new managed {@link Thread}.
     * </p>
     *
     * @param threadPool the {@link AbstractThreadPool} being monitored
     * @param thread the thread that has been allocated
     */
    void onThreadAllocateEvent(AbstractThreadPool threadPool, Thread thread);

    /**
     * <p>
     * This event may be fired when a thread will no longer be managed by the {@link AbstractThreadPool} implementation.
     * </p>
     *
     * @param threadPool the {@link AbstractThreadPool} being monitored
     * @param thread the thread that is no longer being managed by the {@link AbstractThreadPool}
     */
    void onThreadReleaseEvent(AbstractThreadPool threadPool, Thread thread);

    /**
     * <p>
     * This event may be fired when the {@link AbstractThreadPool} implementation has allocated and is managing a number of
     * threads equal to the maximum limit of the pool.
     * <p>
     *
     * @param threadPool the {@link AbstractThreadPool} being monitored
     * @param maxNumberOfThreads the maximum number of threads allowed in the {@link AbstractThreadPool}
     */
    void onMaxNumberOfThreadsEvent(AbstractThreadPool threadPool, int maxNumberOfThreads);

    /**
     * <p>
     * This event may be fired when a task has been queued for processing.
     * </p>
     *
     * @param threadPool the {@link AbstractThreadPool} being monitored
     * @param task a unit of work to be processed
     */
    void onTaskQueueEvent(AbstractThreadPool threadPool, Runnable task);

    /**
     * <p>
     * This event may be fired when a task has been pulled from the queue and is about to be processed.
     * </p>
     *
     * @param threadPool the {@link AbstractThreadPool} being monitored
     * @param task a unit of work that is about to be processed.
     */
    void onTaskDequeueEvent(AbstractThreadPool threadPool, Runnable task);

    /**
     * <p>
     * This event may be fired when a dequeued task has been canceled.
     * </p>
     * This event can occur during shutdownNow() invocation, where tasks are getting pulled out of thread pool queue and
     * returned as the result of shutdownNow() method call.
     *
     * @param threadPool the {@link AbstractThreadPool} being monitored
     * @param task a unit of work that has been canceled
     */
    void onTaskCancelEvent(AbstractThreadPool threadPool, Runnable task);

    /**
     * <p>
     * This event may be fired when a dequeued task has completed processing.
     * </p>
     *
     * @param threadPool the {@link AbstractThreadPool} being monitored
     * @param task the unit of work that has completed processing
     */
    void onTaskCompleteEvent(AbstractThreadPool threadPool, Runnable task);

    /**
     * <p>
     * This event may be fired when the task queue of the {@link AbstractThreadPool} implementation has exceeded its
     * configured size.
     * </p>
     *
     * @param threadPool the {@link AbstractThreadPool} being monitored
     */
    void onTaskQueueOverflowEvent(AbstractThreadPool threadPool);

    // ---------------------------------------------------------- Nested Classes

    /**
     * {@link ThreadPoolProbe} adapter that provides no-op implementations for all interface methods allowing easy extension
     * by the developer.
     *
     * @since 2.1.9
     */
    @SuppressWarnings("UnusedDeclaration")
    class Adapter implements ThreadPoolProbe {

        // ---------------------------------------- Methods from ThreadPoolProbe

        /**
         * {@inheritDoc}
         */
        @Override
        public void onThreadPoolStartEvent(AbstractThreadPool threadPool) {
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onThreadPoolStopEvent(AbstractThreadPool threadPool) {
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onThreadAllocateEvent(AbstractThreadPool threadPool, Thread thread) {
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onThreadReleaseEvent(AbstractThreadPool threadPool, Thread thread) {
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onMaxNumberOfThreadsEvent(AbstractThreadPool threadPool, int maxNumberOfThreads) {
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onTaskQueueEvent(AbstractThreadPool threadPool, Runnable task) {
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onTaskDequeueEvent(AbstractThreadPool threadPool, Runnable task) {
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onTaskCancelEvent(AbstractThreadPool threadPool, Runnable task) {
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onTaskCompleteEvent(AbstractThreadPool threadPool, Runnable task) {
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onTaskQueueOverflowEvent(AbstractThreadPool threadPool) {
        }

    } // END Adapter

}
