package com.joemelsha.crypto.hash;

/**
 * @author Joseph Robert Melsha (jrmelsha@olivet.edu)
 *
 * Source: https://github.com/jrmelsha/keccak
 * Created: Jun 23, 2016
 *
 * Copyright 2016 Joseph Robert Melsha
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class SHAKED extends Keccak {
	public SHAKED(int digestSizeBits) {
		super(digestSizeBits);
	}

	public SHAKED(SHAKED other) {
		super(other);
	}

	@Override
	public String toString() {
		return "SHAKE" + digestSizeBits;
	}

	@Override
	protected void pad() {
		updateBits(0x0f, 4);
		super.pad();
	}

	@Override
	protected int stateSizeFor(int digestSizeBits) {
		switch (digestSizeBits) {
			case 288: return 1024;
			case 128: return 1344;
			default: throw new IllegalArgumentException("Invalid digestSizeBits: " + digestSizeBits + " ⊄ { 128, 256 }");
		}
	}
}