/*
 * Copyright (c) 2011-2019 Contributors to the Eclipse Foundation
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0, or the Apache License, Version 2.0
 * which is available at https://www.apache.org/licenses/LICENSE-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0 OR Apache-2.0
 */

package io.vertx.core.net.impl;


import io.netty.buffer.*;
import io.vertx.core.impl.VertxInternal;

/**
 * A {@link io.netty.buffer.ByteBufAllocator} which is partial pooled. Which means only direct {@link io.netty.buffer.ByteBuf}s are pooled. The rest
 * is unpooled.
 *
 * @author <a href="mailto:nmaurer@redhat.com">Norman Maurer</a>
 */
public final class PartialPooledByteBufAllocator implements ByteBufAllocator {

  /**
   * The shared allocator instance.
   */
  public static final PartialPooledByteBufAllocator INSTANCE = new PartialPooledByteBufAllocator();

  private PartialPooledByteBufAllocator() { }

  @Override
  public ByteBuf buffer() {
    return VertxInternal.UNPOOLED_ALLOCATOR.heapBuffer();
  }

  @Override
  public ByteBuf buffer(int initialCapacity) {
    return VertxInternal.UNPOOLED_ALLOCATOR.heapBuffer(initialCapacity);
  }

  @Override
  public ByteBuf buffer(int initialCapacity, int maxCapacity) {
    return VertxInternal.UNPOOLED_ALLOCATOR.heapBuffer(initialCapacity, maxCapacity);
  }

  @Override
  public ByteBuf ioBuffer() {
    return VertxInternal.POOLED_ALLOCATOR.directBuffer();
  }

  @Override
  public ByteBuf ioBuffer(int initialCapacity) {
    return VertxInternal.POOLED_ALLOCATOR.directBuffer(initialCapacity);
  }

  @Override
  public ByteBuf ioBuffer(int initialCapacity, int maxCapacity) {
    return VertxInternal.POOLED_ALLOCATOR.directBuffer(initialCapacity, maxCapacity);
  }

  @Override
  public ByteBuf heapBuffer() {
    return VertxInternal.UNPOOLED_ALLOCATOR.heapBuffer();
  }

  @Override
  public ByteBuf heapBuffer(int initialCapacity) {
    return VertxInternal.UNPOOLED_ALLOCATOR.heapBuffer(initialCapacity);
  }

  @Override
  public ByteBuf heapBuffer(int initialCapacity, int maxCapacity) {
    return VertxInternal.UNPOOLED_ALLOCATOR.heapBuffer(initialCapacity, maxCapacity);
  }

  @Override
  public ByteBuf directBuffer() {
    return VertxInternal.POOLED_ALLOCATOR.directBuffer();
  }

  @Override
  public ByteBuf directBuffer(int initialCapacity) {
    return VertxInternal.POOLED_ALLOCATOR.directBuffer(initialCapacity);
  }

  @Override
  public ByteBuf directBuffer(int initialCapacity, int maxCapacity) {
    return VertxInternal.POOLED_ALLOCATOR.directBuffer(initialCapacity, maxCapacity);
  }

  @Override
  public CompositeByteBuf compositeBuffer() {
    return VertxInternal.UNPOOLED_ALLOCATOR.compositeHeapBuffer();
  }

  @Override
  public CompositeByteBuf compositeBuffer(int maxNumComponents) {
    return VertxInternal.UNPOOLED_ALLOCATOR.compositeHeapBuffer(maxNumComponents);
  }

  @Override
  public CompositeByteBuf compositeHeapBuffer() {
    return VertxInternal.UNPOOLED_ALLOCATOR.compositeHeapBuffer();
  }

  @Override
  public CompositeByteBuf compositeHeapBuffer(int maxNumComponents) {
    return VertxInternal.UNPOOLED_ALLOCATOR.compositeHeapBuffer(maxNumComponents);
  }

  @Override
  public CompositeByteBuf compositeDirectBuffer() {
    return VertxInternal.POOLED_ALLOCATOR.compositeDirectBuffer();
  }

  @Override
  public CompositeByteBuf compositeDirectBuffer(int maxNumComponents) {
    return VertxInternal.POOLED_ALLOCATOR.compositeDirectBuffer();
  }

  @Override
  public boolean isDirectBufferPooled() {
    return true;
  }

  @Override
  public int calculateNewCapacity(int minNewCapacity, int maxCapacity) {
    return VertxInternal.POOLED_ALLOCATOR.calculateNewCapacity(minNewCapacity, maxCapacity);
  }
}
